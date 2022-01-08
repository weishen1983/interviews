package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class TODO_LeetCode67 {
    public String addBinary(String a, String b) {
//        Integer numA = Integer.parseInt(a, 2);
//        Integer numB = Integer.parseInt(b, 2);
//        Integer sum = numA + numB;
//        return Integer.toBinaryString(sum.intValue());
        return null;
    }

    @Test
    public void Test(){
        String a = "11";
        String b = "1";
        String output = "100";
        Assert.assertEquals(output, addBinary(a, b));
    }
}
