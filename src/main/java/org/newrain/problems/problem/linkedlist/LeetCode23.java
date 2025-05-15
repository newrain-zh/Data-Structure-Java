package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/*
合并 K 个升序链表
 */
public class LeetCode23 {


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode prev = lists[0];
        for (int i = 1; i < lists.length; i++) {
            prev = merge(prev, lists[i]);
        }
        return prev;
    }

    public static ListNode merge(ListNode p, ListNode q) {
        if (p == null || q == null) {
            if (p == null) {
                return q;
            }
            return p;
        }
        ListNode res  = new ListNode(-1);
        ListNode prev = res;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                prev.next = p;
                p         = p.next;
            } else {
                prev.next = q;
                q         = q.next;
            }
            prev = prev.next;
        }

        if (p != null) {
            prev.next = p;
        }
        if (q != null) {
            prev.next = q;
        }
        return res.next;

    }


    public static void main(String[] args) {
        ListNode   listNode1 = LinkListNodeUtils.get(new int[]{1});
        ListNode   listNode2 = LinkListNodeUtils.get(new int[]{0});
        ListNode[] lists     = new ListNode[2];
        lists[0] = listNode1;
        lists[1] = listNode2;
        ListNode merge = mergeKLists(lists);
        LinkListNodeUtils.print(merge);
    }

}