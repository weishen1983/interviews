package com.weishen.java8learning;

public class FilterEmpSalaryLessThan10k implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() < 10000.00;
    }
}
