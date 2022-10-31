package org.newrain.leetcode.offer;

/**
 * 反转链表
 * 输入 2->4->5->null
 * 输出 null->5->4->2
 * <p>
 * null<-2<-4<-5
 */

import org.newrain.leetcode.problem.linkedlist.ListNode;

public class ReverseList {


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //4
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
