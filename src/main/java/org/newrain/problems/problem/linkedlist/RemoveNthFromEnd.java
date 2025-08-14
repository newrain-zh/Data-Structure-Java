package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

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
        ListNode       curr = head;
        List<ListNode> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        if (list.size() == 1) {
            return null;
        }
        int      pos        = list.size() - n;
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

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode dummy = head;
        int      len   = 0;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }
        int pos = len - n;
        if (pos == 0) { // 如果为 0 则说明要删除头节点
            return head.next;
        }
        dummy = head;
        int      count = 0;
        ListNode pre;
        while (dummy != null) {
            count++;
            pre   = dummy;
            dummy = dummy.next;
            if (count == pos) pre.next = dummy.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        LinkListNodeUtils.print(removeNthFromEnd1(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5}), 2));
        LinkListNodeUtils.print(removeNthFromEnd1(LinkListNodeUtils.get(new int[]{1, 2}), 2));
    }

}