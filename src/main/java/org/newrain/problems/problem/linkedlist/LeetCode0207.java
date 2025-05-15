package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;

/**
 * 两个单链表的第一个相交节点
 */
public class LeetCode0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }
}