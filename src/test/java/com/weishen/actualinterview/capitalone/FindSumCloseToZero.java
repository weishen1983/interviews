package com.weishen.actualinterview.capitalone;

import org.junit.Test;

import java.util.Arrays;

public class FindSumCloseToZero {

    public int solution(int[] srcArray){
        int[] sortedArray = Arrays.stream(srcArray).sorted().toArray();
        int sum, minSum = Integer.MAX_VALUE;
        int l = 0;
        int r = sortedArray.length - 1;
        while (l < r) {
            sum = sortedArray[l] + sortedArray[r];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
            }
            if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }
        return minSum;
    }

    @Test
    public void test() {
        int[] srcArray = {3, 5, 1, 2, 5, -9, 7, 6};
        System.out.println(solution(srcArray));
    }
}
