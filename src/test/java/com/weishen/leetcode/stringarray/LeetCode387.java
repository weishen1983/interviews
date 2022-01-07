package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char key = chars[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]).equals(1)) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test(){
        String inputStr = "aabb";
        int expectResult = -1;
        Assert.assertEquals(expectResult, firstUniqChar(inputStr));
    }
}
