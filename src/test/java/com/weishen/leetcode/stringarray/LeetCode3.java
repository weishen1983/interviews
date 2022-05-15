package com.weishen.leetcode.stringarray;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Sliding Window
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * HashSet
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            while (!set.add(cur)) {
                set.remove(s.charAt(left++));
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }


    @Test
    public void test() {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

















}
