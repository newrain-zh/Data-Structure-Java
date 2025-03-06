package org.newrain.code.problem.linkedlist;

import org.newrain.code.problem.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 链表的中间结点
 * @link <a href="https://www.lintcode.com/problem/1609">lintcode</a>
 */
public class MiddleNode {

    /**
     * 使用数组顺序存储节点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tail = head;
        while (tail.next != null) {
            list.add(tail);
            tail = tail.next;
        }
        int pos = list.size() / 2;
        if ((list.size() & 1) != 0) {
            return list.get(pos);
        }
        return list.get(pos + 1);
    }

    /**
     * 快慢指针解法
     *
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        System.out.println(7 / 2);
    }


}