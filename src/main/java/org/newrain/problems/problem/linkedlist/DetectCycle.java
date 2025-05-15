package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 环形链表 II
 * @link <a href="https://leetcode.cn/problems/linked-list-cycle-ii/submissions/">leetcode</a>
 * @complexity middle
 */
public class DetectCycle {

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode pt1 = head;
                while (pt1 != slow) {
                    pt1  = pt1.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode       treeNode = LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5});
        List<ListNode> list     = new ArrayList<>();
        ListNode       curr     = treeNode;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        list.get(list.size() - 1).next = list.get(1);
        ListNode listNode = detectCycle(treeNode);
        System.out.println(listNode.val);
    }
}