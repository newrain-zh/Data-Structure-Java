package org.newrain.problems.problem.utils;

import org.newrain.problems.problem.common.ListNode;

/**
 * 生成链表 打印链表相关工具类
 *
 * @author newrain
 * @description 链表工具类
 */
public class LinkListNodeUtils {


    public static ListNode get(int[] arr) {
        ListNode curr = new ListNode(-1);
        ListNode tail = new ListNode(arr[0]);
        curr.next = tail;
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            tail.next = listNode;
            tail = listNode;
        }
        return curr.next;
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            if (listNode.next != null) {
                System.out.print(listNode.val + "->");
            } else {
                System.out.println(listNode.val + "->null");
            }
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void print(String id, ListNode listNode) {
        System.out.print(id + ":");
        print(listNode);
    }

    public static void main(String[] args) {
        get(new int[]{1, 2, 3});
    }

}