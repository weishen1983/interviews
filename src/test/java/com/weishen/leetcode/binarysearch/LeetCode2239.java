package com.weishen.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-2,1,4,8]
 * Output: 1
 * Explanation:
 * The distance from -4 to 0 is |-4| = 4.
 * The distance from -2 to 0 is |-2| = 2.
 * The distance from 1 to 0 is |1| = 1.
 * The distance from 4 to 0 is |4| = 4.
 * The distance from 8 to 0 is |8| = 8.
 * Thus, the closest number to 0 in the array is 1.
 * Example 2:
 *
 * Input: nums = [2,-1,1]
 * Output: 1
 * Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 */
public class LeetCode2239 {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= 0) {
                r = mid;
            }
            if (nums[mid] < 0) {
                l = mid;
            }
        }
        int leftDis = Math.abs(nums[l]);
        int rightDis = Math.abs(nums[r]);
        if (leftDis < rightDis) {
            return nums[l];
        } else {
            return nums[r];
        }
    }
}
