package com.weishen.leetcode.splitwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Sliding Window
 *
 * Given a string s , find the length of the longest substring t that contains at most k distinct characters.
 *
 * Refer example to 159
 */
public class LeetCode340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        int left = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while(map.size() > k) {
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
    public void test(){
        String s = "aecebaaccceee";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 3));
    }
}
