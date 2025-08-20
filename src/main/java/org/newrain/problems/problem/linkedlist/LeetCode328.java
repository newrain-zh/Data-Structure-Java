package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class LeetCode328 {


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd  = head; // 奇数节点
        ListNode even = head.next; // 偶数节点
        ListNode evenHead = even;     // 保存偶数链表的头，用于最后连接
        while (even != null && even.next != null) {
            // 奇数节点
            odd.next = even.next;
            odd      = odd.next;
            // 偶数节点
            even.next = odd.next;
            even      = even.next;
        }
        // 将奇数链表的尾部连接到偶数链表的头部
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = oddEvenList(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5}));
        LinkListNodeUtils.print(listNode);

    }
}