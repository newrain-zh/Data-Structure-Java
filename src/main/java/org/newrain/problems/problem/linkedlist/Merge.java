package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class Merge {


    public static ListNode merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        ListNode p1   = pHead1;
        ListNode p2   = pHead2;
        ListNode ans  = new ListNode(-1);
        ListNode prev = ans;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ans.next = p1;
                p1       = p1.next;
            } else {
                ans.next = p2;
                p2       = p2.next;
            }
            ans = ans.next;
        }
        if (p1 != null) {
            ans.next = p1;
        }
        if (p2 != null) {
            ans.next = p2;
        }

        return prev.next;
    }

    public static void main(String[] args) {
        LinkListNodeUtils.get(new int[]{1, 3, 5});
        LinkListNodeUtils.print(merge(LinkListNodeUtils.get(new int[]{1, 3, 5}), LinkListNodeUtils.get(new int[]{2, 4, 6})));
        LinkListNodeUtils.print(merge(LinkListNodeUtils.get(new int[]{-1, 2, 4}), LinkListNodeUtils.get(new int[]{1, 3, 4})));

    }
}