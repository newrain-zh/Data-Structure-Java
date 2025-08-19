package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;

public class EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 第一步：判断是否有环
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }

        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 第2步：找出入环点
        ListNode p = pHead;
        ListNode q = slow;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}