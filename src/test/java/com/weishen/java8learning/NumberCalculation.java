package com.weishen.java8learning;

@FunctionalInterface
public interface NumberCalculation<T, R> {

    R calculate(T t1, T tw);
}
