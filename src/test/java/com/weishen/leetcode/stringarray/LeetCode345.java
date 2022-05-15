package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 */
public class LeetCode345 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i=0, j=chars.length-1;
        while(i<=j) {
            //left
            if (!isVowels(chars[i])) {
                i++;
                continue;
            }
            //right
            if (!isVowels(chars[j])) {
                j--;
                continue;
            }
            //switch
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    private boolean isVowels(char c){
        if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
                || c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test(){
        String inputStr = "aA";
        String expectedStr = "Aa";
        Assert.assertEquals(expectedStr, reverseVowels(inputStr));
    }

}
