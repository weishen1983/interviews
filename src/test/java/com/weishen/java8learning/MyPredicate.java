package com.weishen.java8learning;

@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);

    boolean equals(Object obj);
}
