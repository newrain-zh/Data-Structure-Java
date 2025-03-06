package org.newrain.code.problem.linkedlist;

import org.newrain.code.problem.common.ListNode;
import org.newrain.code.problem.utils.LinkListNodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode.82 删除排序链表中的重复元素II
 *
 * @link
 */
public class DeleteDuplicatesII {

    /**
     * 这里不是最优解法
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (ListNode listNode : list) {
            listNode.next = null;
            countMap.put(listNode.val, countMap.getOrDefault(listNode.val, 0) + 1);
        }
        ListNode dumpy = new ListNode(0);
        ListNode prev = dumpy;
        for (ListNode listNode : list) {
            if (countMap.get(listNode.val) == 1) {
                prev.next = listNode;
                prev = listNode;
            }
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = deleteDuplicates(LinkListNodeUtils.get(new int[]{1, 2, 3, 3, 4, 4, 5}));
        LinkListNodeUtils.print(listNode);
    }
}