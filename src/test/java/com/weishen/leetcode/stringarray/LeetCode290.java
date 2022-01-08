package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 */
public class LeetCode290 {

    public boolean wordPattern(String pattern, String s) {
        char[] patternChars = pattern.toCharArray();
        String[] sArray = s.split(" ");
        if (patternChars.length != sArray.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(26, 1f);
        Set<String> usedWordsSet = new HashSet<>();
        for (int i = 0; i < patternChars.length; i++) {
            char key = patternChars[i];
            if (map.containsKey(key) && !map.get(key).equals(sArray[i])) {
                return false;
            }
            if (!map.containsKey(key)) {
                if (usedWordsSet.add(sArray[i])) {
                    map.put(key, sArray[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        String pattern = "abba";
        String s = "cat dog dog cat";
        Assert.assertTrue(wordPattern(pattern, s));
    }

}
