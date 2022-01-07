package com.weishen.actualinterview.amdoc;

import org.junit.Test;

public class PrintPyramid {

    public void printStars(int n){
        int i, j;
        for(i=0; i<n; i++)
        {
            for(j=0; j<=i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    @Test
    public void test(){
        printStars(5);
    }
}
