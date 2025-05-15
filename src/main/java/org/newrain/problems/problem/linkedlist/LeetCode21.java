package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * 合并两个有序链表
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p    = list1;
        ListNode q    = list2;
        ListNode ans  = new ListNode(-1);
        ListNode prev = ans;
        while (p != null && q != null) {
            if (p.val >= q.val) {
                prev.next = q;
                q         = q.next;
            } else {
                prev.next = p;
                p         = p.next;
            }
            prev = prev.next;
        }
        if (p != null) {
            prev.next = p;
        }
        if (q != null) {
            prev.next = q;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new LeetCode21().mergeTwoLists(LinkListNodeUtils.get(new int[]{1, 2, 4}), LinkListNodeUtils.get(new int[]{1, 3, 4}));
        LinkListNodeUtils.print(listNode);

    }
}