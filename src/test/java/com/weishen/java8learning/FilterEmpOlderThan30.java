package com.weishen.java8learning;

public class FilterEmpOlderThan30 implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee e) {
        return e.getAge() > 30;
    }
}
