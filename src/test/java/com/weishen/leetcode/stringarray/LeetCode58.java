package com.weishen.leetcode.stringarray;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean foundWord = false;
        for (int j=s.length()-1; j>=0; j--) {
            if (foundWord && s.charAt(j) != ' ') {
                length ++;
            }
            if (foundWord && s.charAt(j) == ' ') {
                break;
            }
            if (!foundWord && s.charAt(j) != ' ') {
                length ++;
                foundWord = true;
            }
        }
        return length;
    }

//    public int lengthOfLastWord(String s) {
//        String[] sArrays = s.trim().split(" ");
//        return sArrays[sArrays.length-1].length();
//    }

    @Test
    public void test(){
        String s = "      ";
        String[] sArrays = s.trim().split(" ");
        System.out.println(sArrays.length);
        System.out.println(sArrays[sArrays.length-1].length());
        Arrays.stream(sArrays).forEach(System.out::println);
    }

}
