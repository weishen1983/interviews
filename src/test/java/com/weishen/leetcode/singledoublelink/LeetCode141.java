package com.weishen.leetcode.singledoublelink;

import java.util.HashSet;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.hashCode())) {
                return true;
            }
            set.add(head.hashCode());
            head = head.next;
        }
        return false;
    }
}
