package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            char[] strChars = strs[i].toCharArray();
            int loopLength = prefix.length() < strChars.length ? prefix.length() : strChars.length;
            for (int j = 0; j < loopLength; j++) {
                if (strChars[j] == prefix.charAt(j)) {
                    continue;
                } else {
                    prefix = new String(strChars, 0, j);
                    break;
                }
            }
            if (strChars.length < prefix.length()) {
                prefix = new String(strChars, 0, strChars.length);
            }
        }

        return prefix;
    }

    @Test
    public void test(){
        String[] strs = {"flower","flow","flight"};
        String commonPrefix = "fl";
        Assert.assertEquals(commonPrefix, longestCommonPrefix(strs));
//        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
//        String s = new String(chars, 0, 1);
//        System.out.println(s);
    }
}
