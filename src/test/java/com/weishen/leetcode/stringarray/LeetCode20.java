package com.weishen.leetcode.stringarray;

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
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        boolean noRightBracket = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char currentBracket = chars[i];
            if (i == 0 && isRightBracket(currentBracket)) {
                return false;
            }
            if (isLeftBracket(currentBracket)) {
                stack.push(currentBracket);
                continue;
            }
            if (isRightBracket(currentBracket)) {
                noRightBracket = false;
                if (stack.isEmpty() || !isMatchedBracket(stack.pop().charValue(), currentBracket)) {
                    return false;
                }
            }
        }
        if (noRightBracket) {
            return false;
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isLeftBracket(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isRightBracket(char c) {
        if (c == ')' || c == ']' || c == '}') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMatchedBracket(char leftBracket, char rightBracket) {
        if (leftBracket == '(' && rightBracket == ')') {
            return true;
        } else if (leftBracket == '[' && rightBracket == ']') {
            return true;
        } else if (leftBracket == '{' && rightBracket == '}') {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        String inputStr = "(){}}{";
        Assert.assertTrue(isValid(inputStr));
    }
}
