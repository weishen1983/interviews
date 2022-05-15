package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 */
public class LeetCode387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1); //-1 means this is not unique
            } else {
                map.put(s.charAt(i), i);
            }
        }

        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i))!=-1) {
                return map.get(s.charAt(i));
            }
        }

        return -1;
    }

    @Test
    public void test(){
        String inputStr = "leetcode";
        int expectResult = 0;
        Assert.assertEquals(expectResult, firstUniqChar(inputStr));
    }
}
