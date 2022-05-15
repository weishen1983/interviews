package com.weishen.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (isLeftBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop().charValue(), c)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isLeftBracket(char c) {
        if (c=='(' || c=='[' || c=='{' ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMatch(char left, char right) {
        if (left=='(' && right==')') {
            return true;
        } else if (left=='[' && right==']') {
            return true;
        } else if (left=='{' && right=='}') {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        String inputStr = "{[()]}";
        Assert.assertTrue(isValid(inputStr));
    }
}
