package com.weishen.java8learning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    /*
        source:
        {1, 2, 3, 4, 5}
        target:
        {1, 4, 9, 16, 25}
     */
    @Test
    public void test1(){
        List<Integer> sourceList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> targetList = sourceList.stream().map(number -> number * number).collect(Collectors.toList());
        System.out.println(targetList);
    }


}
