package org.newrain.problems.problem.linkedlist;


import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list">...</a>
 */
public class LeetCode83 {


    /**
     * Hints: 最优解法
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next; // 值不相等 继续遍历
            }
        }
        return head;
    }


    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val != prev.val) {
                prev = curr;
                list.add(curr);
            }
            curr = curr.next;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }

    public static void testDeleteDuplicates() {
        ListNode listNode = deleteDuplicates(LinkListNodeUtils.get(new int[]{1, 1, 2})); // 1->2->null
        LinkListNodeUtils.print(listNode);
        ListNode listNode1 = deleteDuplicates(LinkListNodeUtils.get(new int[]{1, 1, 2, 3, 3})); // 1->2->3->null
        LinkListNodeUtils.print(listNode1);
        ListNode listNode2 = deleteDuplicates(LinkListNodeUtils.get(new int[]{1, 1, 1})); // 1->>null
        LinkListNodeUtils.print(listNode2);
    }

    public static void testDeleteDuplicates1() {
        ListNode listNode = deleteDuplicates1(LinkListNodeUtils.get(new int[]{1, 1, 2})); // 1->2->null
        LinkListNodeUtils.print(listNode);
        ListNode listNode1 = deleteDuplicates1(LinkListNodeUtils.get(new int[]{1, 1, 2, 3, 3})); // 1->2->3->null
        LinkListNodeUtils.print(listNode1);
        ListNode listNode2 = deleteDuplicates1(LinkListNodeUtils.get(new int[]{1, 1, 1})); // 1->>null
        LinkListNodeUtils.print(listNode2);
    }


    public static void main(String[] args) {
        testDeleteDuplicates();
        testDeleteDuplicates1();
    }

}