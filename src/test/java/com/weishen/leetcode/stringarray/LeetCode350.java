package com.weishen.leetcode.stringarray;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 350. Intersection of Two Arrays II
 * Easy
 *
 * 3902
 *
 * 647
 *
 * Add to List
 *
 * Share
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for (int i=0; i<nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                resultList.add(nums2[i]);
                if (map.get(nums2[i]) == 1) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], map.get(nums2[i])-1);
                }
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).sorted().boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).sorted().boxed().collect(Collectors.toList());
        list1.addAll(list2);
        int[] sortedNums = list1.stream().mapToInt(Integer::intValue).toArray();
        List<Integer> resultList = new ArrayList<>();
        int l = 0, r = nums1.length;
        while (l < nums1.length && r < sortedNums.length) {
            if (sortedNums[l] == sortedNums[r]) {
                resultList.add(sortedNums[l]);
                l++;
                r++;
            } else if (sortedNums[l] > sortedNums[r]) {
                r++;
            } else {
                l++;
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test(){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        Arrays.stream(intersect(nums1, nums2)).forEach(System.out::println);
    }
}
