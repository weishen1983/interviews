package com.weishen.actualinterview.amdoc;

import org.junit.Test;

import java.util.Arrays;

public class fibonacci {

    public void printFibonacci(int number) {

        if (number == 1) {
            System.out.println(0);
            return;
        }

        if (number == 2) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] arrays = new int[number];
        arrays[0] = 0;
        arrays[1] = 1;
        for (int i = 2; i < number; i++) {
            arrays[i] = arrays[i-2] + arrays[i-1];
        }
        Arrays.stream(arrays).forEach((num) -> System.out.print(num + " "));
    }

    @Test
    public void test(){
        printFibonacci(10);
    }

}
