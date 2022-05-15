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
        int i=0, j=s.length()-1;
        while (i<=j) {
            //left
            char left = s.charAt(i);
            if (!isAlphanumeric(left)) {
                i++;
                continue;
            }
            //right
            char right = s.charAt(j);
            if (!isAlphanumeric(right)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(left)!=Character.toLowerCase(right)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if (c=='a' || c=='b' || c=='c' || c=='d' || c=='e' || c=='f' || c=='g'
                || c=='h' || c=='i' || c=='j' || c=='k' || c=='l' || c=='m' || c=='n'
                || c=='o' || c=='p' || c=='q' || c=='r' || c=='s' || c=='t' || c=='u'
                || c=='v' || c=='w' || c=='x' || c=='y' || c=='z' || c=='A' || c=='B'
                || c=='C' || c=='D' || c=='E' || c=='F' || c=='G' || c=='H' || c=='I'
                || c=='J' || c=='K' || c=='L' || c=='M' || c=='N' || c=='O' || c=='P'
                || c=='Q' || c=='R' || c=='S' || c=='T' || c=='U' || c=='V' || c=='W'
                || c=='X' || c=='Y' || c=='Z' || c=='0' || c=='1' || c=='2' || c=='3'
                || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9') {
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
