package org.newrain.code.problem.linkedlist;

/**
 * @author NewRain
 * @complexity easy
 * @description 反转链表
 * @tag 链表 递归
 * @link <a href="https://leetcode.cn/problems/reverse-linked-list/">leetcode</a>
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            //2
            ListNode next = curr.next;
            //下一节点的指针指向上一节点
            curr.next = prev;
            //上一节点为当前节点
            prev = curr;
            //获取下一节点
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        reverseList(head);


    }
}
