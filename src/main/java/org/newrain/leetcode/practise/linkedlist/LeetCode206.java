package org.newrain.leetcode.practise.linkedlist;

/**
 * 反转链表
 * 输入 2->4->5->null
 * 输出 null->5->4->2
 * <p>
 * null<-2<-4<-5
 */
public class LeetCode206 {

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
