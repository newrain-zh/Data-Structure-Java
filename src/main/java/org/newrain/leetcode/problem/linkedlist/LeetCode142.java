package org.newrain.leetcode.problem.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author newRain
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
