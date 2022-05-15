package com.weishen.leetcode.stringarray;

import org.junit.Test;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxArea = 0;
        int leftLength = 0, rightLength = 0;
        while (l < r) {
            leftLength = height[l];
            rightLength = height[r];
            int currentArea = leftLength < rightLength ? leftLength * (r - l) : rightLength * (r - l);
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
            if (leftLength < rightLength) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

//    public int maxArea(int[] height) {
//        int i=0, j=height.length-1, maxArea=0;
//        while(i <= j){
//            if(height[i] < height[j]) {
//                maxArea = Math.max(maxArea, height[i] * (j - i));
//                i++;
//            }else{
//                maxArea = Math.max(maxArea, height[j] * (j - i));
//                j--;
//            }
//        }
//        return maxArea;
//    }
}
