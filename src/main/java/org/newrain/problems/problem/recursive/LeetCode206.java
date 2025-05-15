package org.newrain.problems.problem.recursive;


import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">...</a>
 */
public class LeetCode206 {

    //  1 -> 2 -> 3 -> 4 -> 5->null
    public static ListNode reverseList(ListNode head) { // 4
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);// 5
        LinkListNodeUtils.print(newHead);
        System.out.println("newHead.val="+newHead.val);
        // 原先 4.next = 5 现在要变成 5.next = 4
        // 4.next(5).next(null) = head(4)
        // 原先 4 -> 5 -> null
        // 4->5->4->5 这里成了环形
        // 将当前节点的下一个节点指向自己
        head.next.next = head;
        // 4->null 此时 newHead的节点情况为 5->4->5->4......
        head.next = null; // 这里进行断开操作 5->4->null
        return newHead;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        reverseList(listNode);

    }

}