package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class HasCycle {


    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2});
        System.out.println(hasCycle(listNode));
    }
}