package com.weishen.leetcode.stringarray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class LeetCode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> resultList = new ArrayList<>();
        if (s.length() <= 10) {
            return resultList;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10 ; i++) {
            String key = s.substring(i, i + 10);
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                if (value.intValue() == 1) {
                    resultList.add(key);
                }
                map.put(key, Integer.valueOf(value.intValue() + 1));
            } else {
                map.put(key, Integer.valueOf(1));
            }
        }
        return resultList;
    }

    @Test
    public void test() {
//        String s = "abcdefghijklmnopqrstuvwxyz";
//        System.out.println(s.substring(s.length() - 10, s.length() - 10 + 10));
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        findRepeatedDnaSequences(s).stream().forEach(System.out::println);
    }
}
