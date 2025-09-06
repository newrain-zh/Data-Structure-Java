package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;

public class ReverseKGroup {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev      = dummy;
        ListNode groupTail = null;
        while (dummy != null) {
            ListNode check = prev;
            for (int i = 0; i < k; i++) {
                check = check.next;
                if (check == null) {
                    return dummy.next;
                }
            }
            ListNode curr  = prev.next;
            ListNode next  = null;
            ListNode group = prev;
            for (int i = 0; i < k; i++) {
                next      = curr.next; // 保存下一个节点
                curr.next = group;
                group     = curr;
                curr      = next;
            }

        }
        return null;

    }
}