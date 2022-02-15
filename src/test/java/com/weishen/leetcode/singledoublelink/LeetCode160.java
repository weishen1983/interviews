package com.weishen.leetcode.singledoublelink;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<Integer> set = new HashSet<>();
        while (headA != null) {
            set.add(headA.hashCode());
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB.hashCode())) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
