package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class LeetCode205 {

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Map<Character, Character> map = new HashMap<>(s.length());
        for (int i = 0; i < schars.length; i++) {
            char schar = schars[i];
            char tchar = tchars[i];
            if (map.containsKey(schar) && map.get(schar).charValue() != tchar) {
                return false;
            } else {
                map.put(schar, tchar);
            }
        }

        map = new HashMap<>(s.length());
        for (int i = 0; i < tchars.length; i++) {
            char schar = schars[i];
            char tchar = tchars[i];
            if (map.containsKey(tchar) && map.get(tchar).charValue() != schar) {
                return false;
            } else {
                map.put(tchar, schar);
            }
        }

        return true;
    }

    @Test
    public void test(){
        String inputStr1 = "badc";
        String inputStr2 = "baba";
        Assert.assertTrue(isIsomorphic(inputStr1, inputStr2));
    }
}
