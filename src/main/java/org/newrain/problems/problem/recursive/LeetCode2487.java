package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/remove-nodes-from-linked-list">...</a>
 */
public class LeetCode2487 {


    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head); // 反转链表 从右->左处理
        LinkListNodeUtils.print(listNode);

        // 保存头节点

        ListNode currentNode = listNode;
        ListNode prevNode = listNode; // 前驱节点
        int maxValue = listNode.val;

        currentNode = currentNode.next;

        while (currentNode != null) {
            if (currentNode.val >= maxValue) {
                maxValue = currentNode.val;
                prevNode.next = currentNode;
                prevNode = currentNode;
            } else {
                // A->B->C->D
                // currentNode = C->D
                // prevNode = B->C->D
                // B->D
                prevNode.next = currentNode.next; // 将当前节点currentNode从链表中删除
            }
            currentNode = currentNode.next;
        }
        return reverseList(listNode);
    }


    public ListNode removeNodes1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head); // 反转链表 从右->左处理
        LinkListNodeUtils.print(listNode);
        ListNode cur = listNode;
        while (cur.next != null) {
            if (cur.val > cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return reverseList(listNode);
    }

    public static ListNode prev = new ListNode(Integer.MAX_VALUE);


    // 反转链表
    // 该处代码要优化 能提高性能
    // 5->2->13->3->8->null
    // null<-5<-2<-13<-3<-8
    public static ListNode dfs(ListNode currNode, ListNode[] arr) {
        if (currNode == null || currNode.next == null) {
            return currNode;
        }
        ListNode next = dfs(currNode.next, arr);
        arr[0].next = next;
        currNode.next = null; // 先断开当前节与后面节点的连接 3->null
        next.next = currNode; // 反转 8->3->null
        arr[0] = currNode;  // 更新前驱节点
        return currNode;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode[] arr = new ListNode[]{dummyNode};
        dfs(head, arr);
        return dummyNode.next;
    }

    public static void main(String[] args) {
/*      // 测试反转链表
        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5});
        ListNode res = reverseList(listNode);
        LinkListNodeUtils.print(res);*/
        LinkListNodeUtils.print(new LeetCode2487().removeNodes1(LinkListNodeUtils.get(new int[]{5, 2, 13, 3, 8})));
    }
}