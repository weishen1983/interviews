package com.weishen.java8learning;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
Stream的三个操作步骤：
1. 创建Stream
2. 中间操作
3. 终止/终端操作
*/
public class StreamAPITest2 {
    private List<Employee> employees = Arrays.asList(
            new Employee("Tom", 36, 6666.66),
            new Employee("YoYo", 25, 5555.55),
            new Employee("JoJo", 18, 3333.33),
            new Employee("MaMa", 45, 8888.88),
            new Employee("BaBa", 51, 19999.99),
            new Employee("aBaBa", 51, 19999.99),
            new Employee("BaBa", 51, 19999.99)
    );

    //中间操作
    /*
        帅选与切片:
        filter: 接收Lambda，从流中排除某些元素
        limit: 截断流，使其元素不超过盖顶数量
        skip(n): 跳过元素，返回一个扔掉了前n个元素的流，如果流中元素不足n个，则返回一个空流，与limit(n)互补
        distinct: 帅选，通过流所生成元素的hashCode()和equals()去除重复元素
    */
    @Test
    public void test1(){
        //中间操作: 不会执行任何操作
        //内部迭代: 迭代器操作由Stream API完成
        Stream<Employee> stream = employees.stream()
                .filter(e -> {
                    System.out.println("Stream API 的中间操作");
                    return e.getAge() > 30;
                });

        //终止操作： 一次性执行全部内容，称作"惰性求值"
        stream.forEach(System.out::println);
        /* 打印结果:
            Stream API 的中间操作
            Employee{name='Tom', age=36, salary=6666.66}
            Stream API 的中间操作
            Stream API 的中间操作
            Stream API 的中间操作
            Employee{name='MaMa', age=45, salary=8888.88}
            Stream API 的中间操作
            Employee{name='BaBa', age=51, salary=19999.99}
         */
    }

    //外部迭代
    @Test
    public void test2() {
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testDistinct() {
        //We have to override hashcode and equals method
        employees.stream().distinct().forEach(System.out::println);
    }

    //中间操作
    /*
        映射:
        map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        flatmap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后吧所有流连接成一个流
        difference between map and flatmap is kind of difference between list.add and list.addall
     */
    @Test
    public void test3(){
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        strList.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        //提取emplist中所有的name
        employees.stream()
                //.map(employee -> employee.getName())
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    //中间操作
    /*
        陪许:
        sorted()--自然排序(Comparable)
        sorted(Comparator com)--定制排序(Comparator)
     */
    @Test
    public void testSorted() {
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        strList.stream()
                .sorted()
                .forEach(System.out::println);

        //先按年龄排，年龄一样按姓名排
        employees.stream()
                .sorted((emp1, emp2) -> {
                    if (emp1.getAge() == emp2.getAge()) {
                        return emp1.getName().compareTo(emp2.getName());
                    } else {
                        return Integer.compare(emp1.getAge(), emp2.getAge());
                    }
                })
                .forEach(System.out::println);
    }
}
