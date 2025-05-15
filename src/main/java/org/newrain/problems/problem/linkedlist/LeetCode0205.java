package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * 链表求和
 */
public class LeetCode0205 {


    /*
    输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
    输出：2 -> 1 -> 9，即912
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1    = l1;
        ListNode p2    = l2;
        int      carry = 0;
        ListNode ans   = new ListNode(-1);
        ListNode prev  = ans;
        while (p1 != null || p2 != null) {
            int p1Val = p1 == null ? 0 : p1.val;
            int p2Val = p2 == null ? 0 : p2.val;
            int sum   = p1Val + p2Val + carry;
            prev.next = new ListNode(sum % 10);
            prev      = prev.next;
            carry     = sum / 10;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1       = LinkListNodeUtils.get(new int[]{7, 1, 6});
        ListNode l2       = LinkListNodeUtils.get(new int[]{5, 9, 2});
        ListNode listNode = addTwoNumbers(l1, l2);
        LinkListNodeUtils.print(listNode);

    }


}