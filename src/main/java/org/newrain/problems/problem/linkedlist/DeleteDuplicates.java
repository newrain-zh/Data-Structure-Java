package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class DeleteDuplicates {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // prev指针指向当前确定不重复的节点
        ListNode prev = dummy;
        // current指针用于遍历链表
        ListNode current = head;

        while (current != null) {
            boolean has = false;
            while (current.next != null && current.val == current.next.val) {
                has   = true;
                current = current.next;
            }
            if (has) { // 有重复
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
//        LinkListNodeUtils.print(deleteDuplicates(LinkListNodeUtils.get(new int[]{1, 1, 2, 3, 3})));
//        LinkListNodeUtils.print(deleteDuplicates(LinkListNodeUtils.get(new int[]{1, 1, 1})));
        LinkListNodeUtils.print(deleteDuplicates1(LinkListNodeUtils.get(new int[]{1, 1, 1, 2, 3})));
    }
}