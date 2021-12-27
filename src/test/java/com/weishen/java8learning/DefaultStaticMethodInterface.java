package com.weishen.java8learning;

public interface DefaultStaticMethodInterface {

    default String getName(){
        return "default method getName";
    }

    static void show(){
        System.out.println("static method in interface");
    }
}
