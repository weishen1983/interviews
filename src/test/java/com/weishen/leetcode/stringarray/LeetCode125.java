package com.weishen.leetcode.stringarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class LeetCode125 {

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char leftChar = Character.toLowerCase(chars[i]);
            char rightChar = Character.toLowerCase(chars[j]);
            if (isAlphanumeric(leftChar) && isAlphanumeric(rightChar)) {
                if (leftChar != rightChar) {
                    return false;
                } else {
                    i++;
                    j--;
                    continue;
                }
            }
            if (!isAlphanumeric(leftChar) && isAlphanumeric(rightChar)) {
                i++;
                continue;
            }
            if (isAlphanumeric(leftChar) && !isAlphanumeric(rightChar)) {
                j--;
                continue;
            }
            if (!isAlphanumeric(leftChar) && !isAlphanumeric(rightChar)) {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g' || c == 'h' || c == 'i' || c == 'j' || c == 'k'
                || c == 'l' || c == 'm' || c == 'n' || c == 'o' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'u'
                || c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z'
                || c == '1' || c == '2' || c == '3' || c == '4' || c == '5'
                || c == '6' || c == '7' || c == '8' || c == '9' || c == '0') {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        String inputStr = "0P";
        Assert.assertTrue(isPalindrome(inputStr));
    }
}
