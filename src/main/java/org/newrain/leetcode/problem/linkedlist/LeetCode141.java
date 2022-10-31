package org.newrain.leetcode.problem.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141 {


    public boolean hasCycle(ListNode head) {
        ListNode tail = head;
        if (tail == null || tail.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (tail.next != null) {
            if (set.contains(tail)) {
                return true;
            } else {
                set.add(tail);
            }
            tail = tail.next;
        }
        return false;
    }
}
