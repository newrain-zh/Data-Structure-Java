package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/*
 删除中间节点
 */
public class LeetCode0203 {

    // 本题中描述给的不是链表的头节点
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkListNodeUtils.get(new int[]{4, 5, 1, 9});
        deleteNode(listNode);
        LinkListNodeUtils.print(listNode);

    }


}