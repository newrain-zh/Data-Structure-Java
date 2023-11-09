package org.newrain.code.cracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * @author NewRain
 * @link <a href="https://leetcode.cn/problems/remove-duplicate-node-lcci/">leetcode</a>
 */
public class RemoveDuplicateNodes {

    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode tail = head;
        List<Integer> list = new ArrayList<>();
        while (tail != null) {
            if (!list.contains(tail.val)) {
                list.add(tail.val);
            }
            tail = tail.next;
        }
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return new ListNode(list.get(0));
        }
        List<ListNode> listNodes = new ArrayList<>();
        for (int v : list) {
            listNodes.add(new ListNode(v));
        }
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        return listNodes.get(0);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        removeDuplicateNodes(getTestNode1());
        removeDuplicateNodes(getTestNode2());
    }

    public static ListNode getTestNode2() {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);

        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        return head;
    }


    public static ListNode getTestNode1() {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);


        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;
        return head;
    }
}