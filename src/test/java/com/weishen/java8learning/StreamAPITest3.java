package com.weishen.java8learning;

import org.junit.Test;

import java.net.CookieManager;
import java.util.*;
import java.util.stream.Collectors;

/*
Stream的三个操作步骤：
1. 创建Stream
2. 中间操作
3. 终止/终端操作
*/
public class StreamAPITest3 {

    private List<Employee> employees = Arrays.asList(
            new Employee("Tom", 36, 6666.66, Employee.Status.FREE),
            new Employee("YoYo", 25, 5555.55, Employee.Status.BUSY),
            new Employee("JoJo", 18, 3333.33, Employee.Status.VACATION),
            new Employee("MaMa", 45, 8888.88, Employee.Status.BUSY),
            new Employee("BaBa", 51, 19999.99, Employee.Status.FREE)
    );

    //终止/终端操作
    /*
        查找与匹配
        allMatch--检查是否陪陪所有元素
        anyMatch--检查是否至少匹配一个元素
        noneMatch--检查是否没有匹配所有元素
        findFirst--返回第一个元素
        findAny--返回当前流中的任意元素
        count--返回流中元素的总个数
        max--返回流中最大值
        min--返回流中最小值
    */
    @Test
    public void test1(){
        boolean b1 = employees.stream()
                .allMatch(emp -> emp.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream()
                .anyMatch(emp -> emp.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = employees.stream()
                .noneMatch(emp -> emp.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);

        Optional<Employee> op1 = employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()))
                .findFirst();
        System.out.println(op1.get());

        Optional<Employee> op2 = employees.stream() //串行stream，一个一个找，单线程
        //Optional<Employee> op2 = employees.parallelStream() //并行stream，多线程找，谁先找到先返回
                .filter(employee -> employee.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op2.get());
    }

    @Test
    public void test2(){
        Long count = employees.stream().count();
        System.out.println(count);

        Optional<Employee> op1 = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op1.get());

        Optional<Double> op2 = employees.stream()
                        .map(Employee::getSalary)
                                .min(Double::compare);
        System.out.println(op2.get());
    }

    //终止/终端操作
    /*
        归约
        reduce(T identity, BinaryOperator) / reduce(BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值
    */
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);//从0开始计算，第一次计算时，x是0，y是1
        System.out.println(sum);

        //sum the salary of all employees
        //从salary1开始计算，所以有可能为空
        Optional<Double> sumSalary = employees.stream()
                //.map(Employee::getSalary)
                .map(emp -> emp.getSalary())
                //.reduce(Double::sum)
                .reduce((salary1, salary2) -> salary1 + salary2);
        System.out.println(sumSalary);
    }

    //终止/终端操作
    /*
        收集
        collect--将流转换为其他形式。接收一个Collector借口的实现，用于给Stream中元素做汇总的方法
    */
    @Test
    public void test4(){
        List<String> nameList = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);

        HashSet<String> hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));//special collection
        hashSet.forEach(System.out::println);
    }

    @Test
    public void test5(){
        System.out.println(employees.stream().count());
        System.out.println(employees.stream().collect(Collectors.counting()));

        //Average Salary
        System.out.println(employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary)));

        //Sum Salary
        System.out.println(employees.stream().map(Employee::getSalary).reduce(Double::sum).get());
        System.out.println(employees.stream().collect(Collectors.summingDouble(Employee::getSalary)));

        //Max Salary
        System.out.println(employees.stream().map(Employee::getSalary).max(Double::compare));
        System.out.println(employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))).get().getSalary());

        //Min Salary
        System.out.println(employees.stream().map(Employee::getSalary).min(Double::compare));
        System.out.println(employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare)).get());
    }

    @Test
    public void test6(){
        //Group by employee status
        Map<Employee.Status, List<Employee>> map1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map1);

        //多级分组
        Map<Employee.Status, Map<String, List<Employee>>> map2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getName)));

        //分区
        Map<Boolean, List<Employee>> map3 =  employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(map3);

        //连接name字符串，并且用逗号分割
        String nameList = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "===", "==="));
        System.out.println(nameList);
    }
}
