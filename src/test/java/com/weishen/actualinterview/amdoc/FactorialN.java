package com.weishen.actualinterview.amdoc;

import org.junit.Test;

public class FactorialN {

    public int factorialN(int number) {
        if (number == 0) {
            return 1;
        }

        int result = number;
        for (int i = number; i > 1; i--) {
            result = result * (number - 1);
            number--;
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(factorialN(5));
    }
}
