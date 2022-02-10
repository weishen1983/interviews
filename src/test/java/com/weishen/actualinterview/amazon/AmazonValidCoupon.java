package com.weishen.actualinterview.amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * daabbd   valid       1
 * abc      invalid     0
 */
public class AmazonValidCoupon {

    public List<Integer> findValidDiscountCoupons(List<String> discount) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < discount.size(); i++) {
            resultList.add(isValid(discount.get(i)) ? 1 : 0);
        }
        return resultList;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void test(){
        List<String> sourceList = Arrays.asList("daabbd", "abc");
        findValidDiscountCoupons(sourceList).stream().forEach(System.out::println);
    }

}
