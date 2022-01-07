package com.weishen.leetcode.twopointers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        //find the first element whose value is 0;
        while (j < nums.length) {
            if (nums[i] != 0) {
                i++;
                j++;
            } else {
                j++;
                break;
            }
        }

        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

    @Test
    public void test(){
        int[] inputArray = {0, 1, 0, 3, 12};
        int[] expectArray = {1, 3, 12, 0, 0};
        moveZeroes(inputArray);
        Assert.assertArrayEquals(expectArray, inputArray);
    }
}
