package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 */
public class LeetCode28 {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        for (int i = 0; i < hs.length; i++) {
            if (ns.length > hs.length - i) {
                return -1;
            }
            int hCurrentIndex = i;
            boolean isFindNeedle = true;
            for (int j = 0; j < ns.length; j++) {
                if (ns[j] != hs[hCurrentIndex]) {
                    isFindNeedle = false;
                    break;
                }
                hCurrentIndex++;
            }
            if (isFindNeedle) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String haystack = "mississippi";
        String needle = "mississippi";
        int expectedInt = 0;
        Assert.assertEquals(expectedInt, strStr(haystack, needle));
    }
}
