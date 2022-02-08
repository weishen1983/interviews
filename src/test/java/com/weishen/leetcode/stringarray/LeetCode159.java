package com.weishen.leetcode.stringarray;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Sliding Window
 *
 * Given a string s , find the length of the longest substring t that contains at most 2 distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: tis "ece" which its length is 3.
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: tis "aabbb" which its length is 5.
 */
public class LeetCode159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    @Test
    public void test() {
        String s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

}
