package org.newrain.problems.offer;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> dict = new HashSet<>();
        ListNode l1 = headA;
        while (l1 != null) {
            dict.add(l1);
            l1 = l1.next;
        }
        ListNode l2 = headB;
        while (l2 != null) {
            if (dict.contains(l2)) {
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}