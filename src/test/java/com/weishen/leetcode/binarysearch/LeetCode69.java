package com.weishen.leetcode.binarysearch;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
