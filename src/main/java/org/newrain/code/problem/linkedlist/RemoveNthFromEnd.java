package org.newrain.code.problem.linkedlist;

import org.newrain.code.problem.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 删除链表中倒数第n个节点
 * @link <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">LeetCode</a>
 * @link <a href="https://www.lintcode.com/problem/174/">lintcode</a>
 */
public class RemoveNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        if (list.size() == 1) {
            return null;
        }
        int pos = list.size() - n;
        ListNode deleteNode = list.get(pos);
        //[1,2] 1
        if (pos - 1 >= 0) {
            ListNode prev = list.get(pos - 1);
            prev.next = deleteNode.next;
            return list.get(0);
        } else {
            return list.get(1);
        }
    }

}