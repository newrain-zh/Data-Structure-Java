package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class OddEvenList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
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
//        LinkListNodeUtils.print(oddEvenList(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5, 6})));
        LinkListNodeUtils.print(oddEvenList(LinkListNodeUtils.get(new int[]{2, 1, 3, 5, 6, 4, 7})));

    }
}