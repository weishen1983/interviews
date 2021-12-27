package com.weishen.java8learning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
Stream的三个操作步骤：
1. 创建Stream
2. 中间操作
3. 终止/终端操作
*/
public class StreamAPITest1 {

    //创建Stream的四种方式
    @Test
    public void testCreateStream(){
        //1. 可以通过Collection系列集合提供的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();

        //2. 通过Arrays中的静态方法stream()获取数组流
        Employee[] empArray = new Employee[10];
        Stream<Employee> s2 = Arrays.stream(empArray);

        //3. 通过Stream类中的静态方法of()
        Stream<String> s3 = Stream.of("aa", "bb", "cc");

        //4. 创建无限流
        //4.1 迭代, 无限生成数据从零开始每次加一
        Stream<Integer> s4 = Stream.iterate(0, x -> x + 1);
        s4.limit(10).forEach(System.out::println);
        //4.2 生成
        Stream<Double> s5 = Stream.generate(() -> Math.random());
        s5.limit(20).forEach(System.out::println);
    }
}
