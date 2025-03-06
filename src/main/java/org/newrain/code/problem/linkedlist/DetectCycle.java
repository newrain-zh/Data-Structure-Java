package org.newrain.code.problem.linkedlist;

import org.newrain.code.problem.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author NewRain
 * @description 环形链表 II
 * @link <a href="https://leetcode.cn/problems/linked-list-cycle-ii/submissions/">leetcode</a>
 * @complexity middle
 */
public class DetectCycle {

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