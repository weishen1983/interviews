package com.weishen.java8learning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Test {

    private List<Employee> employees = Arrays.asList(
            new Employee("Tom", 36, 6666.66, Employee.Status.FREE),
            new Employee("YoYo", 25, 5555.55, Employee.Status.BUSY),
            new Employee("JoJo", 18, 3333.33, Employee.Status.VACATION),
            new Employee("MaMa", 45, 8888.88, Employee.Status.BUSY),
            new Employee("BaBa", 51, 19999.99, Employee.Status.FREE)
    );

    @Test
    //Why Steam API
    //Need the name list of all employees who is older than 35
    public void test1(){
        List<String> nameList = employees.stream()
                .filter(e -> e.getSalary() > 35) //Lambda Expression and Functional Interface
                //.map(e -> e.getName())
                .map(Employee::getName) //Method Reference
                .collect(Collectors.toList());

        nameList.stream().forEach(System.out::println);
    }

    //Lambda
    @Test
    public void test2(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread created by anonymous class");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Thread created by Lambda Expression"));
    }

    //Functional Interface
    //Default And Static Methods in Interfaces
    @Test
    public void test3(){
        employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(System.out::println);
    }

    /*
        Common predefined functional interface
        Function: To transform arguments in returnable value.
        Predicate: To perform a test and return a Boolean value.
        Consumer: Accept arguments but do not return any values.
        Supplier: Do not accept any arguments but return a value.
     */
    @Test
    public void test4(){
        //Function interface
        employees.stream()
                .map(e -> e.getName())
                .forEach(System.out::println);

        //Predicate interface
        employees.stream()
                .filter(e -> e.getAge() > 35)
                .forEach(System.out::println);

        //Consumer interface
        employees.stream()
                //.forEach(System.out::println);
                .forEach((employee) -> System.out.println(employee.toString()));

        //Supplier interface
        Stream.generate(() -> Math.random()).limit(20).forEach(System.out::println);
    }

    //Optional Class
    @Test
    public void test5(){
        Optional<Employee> op1 = employees.stream()
                .sorted((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()))
                .findFirst();
        System.out.println(op1.get());
    }
}
