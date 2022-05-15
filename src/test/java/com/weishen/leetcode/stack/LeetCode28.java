package com.weishen.leetcode.stack;

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
        if (needle.length() == 0) {
            return 0;
        }
        for (int i=0; i<haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            } else {
                int startIndex = i;
                boolean hasMatch = true;
                for (int j=0; j<needle.length(); j++) {
                    if (startIndex >= haystack.length()) {
                        return -1;
                    }
                    if (haystack.charAt(startIndex) != needle.charAt(j)) {
                        hasMatch = false;
                        break;
                    } else {
                        startIndex++;
                    }
                }
                if (hasMatch) {
                    return i;
                }
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
