package com.weishen.java8learning;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaLambdaTest {
    private List<Employee> employees = Arrays.asList(
      new Employee("Tom", 36, 6666.66),
      new Employee("YoYo", 25, 5555.55),
      new Employee("JoJo", 18, 3333.33),
      new Employee("MaMa", 45, 8888.88),
      new Employee("BaBa", 51, 19999.99)
    );

    //Requirements, get below two requirements one by one, not at the same time
    //1. Get all employees who are older than 30
    //2. Get all employees whose salary is less than 10000

    //Solution 1: Traditional Solution
    @Test
    public void traditionalFilter(){
        //Implement requirement 1 at first
        List<Employee> empsOlderThan30 = filterOlderThan30(employees);
        System.out.println(empsOlderThan30.toString());

        //Than we need to write a new method for the second requirement
        List<Employee> empsSalaryLessThan10k = filterSalaryLessThan10k(employees);
        System.out.println(empsSalaryLessThan10k.toString());
    }

    private List<Employee> filterOlderThan30(List<Employee> originalEmpList) {
        List<Employee> filterEmpList = new ArrayList<Employee>();
        for (Employee e : originalEmpList) {
            if (e.getAge() > 30) {
                filterEmpList.add(e);
            }
        }
        return filterEmpList;
    }

    private List<Employee> filterSalaryLessThan10k(List<Employee> originalEmpList) {
        List<Employee> filterEmpList = new ArrayList<Employee>();
        for (Employee e : originalEmpList) {
            if (e.getSalary() < 10000.00) {
                filterEmpList.add(e);
            }
        }
        return filterEmpList;
    }

    //Solution 2: Strategy Design Pattern
    //Reason why it is better than solution 1
    //1. Only need one method filterEmployeesByPredicator
    //2. for each new requirement, you just need to create new predicator, do not need to change many codes in this class (Yes to open, no to modification)
    @Test
    public void strategyDesignPatternFilter(){
        //Implement requirement 1 at first
        List<Employee> empsOlderThan30 = filterEmployeesByPredicator(employees, new FilterEmpOlderThan30());
        System.out.println(empsOlderThan30.toString());

        //Than we need to write a new method for the second requirement
        List<Employee> empsSalaryLessThan10k = filterEmployeesByPredicator(employees, new FilterEmpSalaryLessThan10k());
        System.out.println(empsSalaryLessThan10k.toString());
    }

    private List<Employee> filterEmployeesByPredicator(List<Employee> originalEmpList, MyPredicate<Employee> mp) {
        List<Employee> filterEmpList = new ArrayList<Employee>();
        for(Employee employee : originalEmpList) {
            if (mp.test(employee)) {
                filterEmpList.add(employee);
            }
        }
        return filterEmpList;
    }

    //Solution 3: Anonymous class
    //No need to create new predicator
    @Test
    public void anonymousMethodFilter(){
        //Implement requirement 1 at first
        List<Employee> empsOlderThan30 = filterEmployeesByPredicator(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 30;
            }
        });
        System.out.println(empsOlderThan30.toString());

        //Than we need to write a new method for the second requirement
        List<Employee> empsSalaryLessThan10k = filterEmployeesByPredicator(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 10000.00;
            }
        });
        System.out.println(empsSalaryLessThan10k.toString());
    }

    //Solution 4: Lambda Expression
    //No need for useless code in solution 3
    @Test
    public void lambdaExpressionFilter(){
        //Implement requirement 1 at first
        List<Employee> empsOlderThan30 = filterEmployeesByPredicator(employees, (e) -> e.getAge() > 30);
        System.out.println(empsOlderThan30.toString());

        //Than we need to write a new method for the second requirement
        List<Employee> empsSalaryLessThan10k = filterEmployeesByPredicator(employees, (e) -> e.getSalary() < 10000.00);
        System.out.println(empsSalaryLessThan10k.toString());
    }

    //Solution 5: Using Steam API:
    //No need for any above methods
    @Test
    public void steamApiFilter(){
        List<Employee> empsOlderThan30 = employees.stream()
                .filter((e) -> e.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println(empsOlderThan30.toString());

        employees.stream()
                .filter((e) -> e.getSalary() < 10000.00)
                .filter((e) -> e.getAge() > 30)
                .forEach(System.out::println);
    }
}
