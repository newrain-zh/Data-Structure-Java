package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * LeetCode.19 删除链表的倒数第 N 个节点
 */
public class LeetCode19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int len = getLen(head);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (len == n) { // 如果是删除头节点 头节点没办法通过下面的方式处理 只能单独处理
            return head.next;
        }
        len++; // 因为加了虚拟节点这里要+1
        ListNode prevDeleteNode = dummy; // 记录要删除的上一个节点
        while (dummy != null) {
            len--;
            if (len + 1 == n) { // 如果下一个节点就是要删除的节点
                break;
            }
            prevDeleteNode = dummy;
            dummy          = dummy.next;
        }
        prevDeleteNode.next = prevDeleteNode.next.next;
        return head;
    }

    public static int getLen(ListNode head) {
        ListNode dummy = head;
        int      len   = 0;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }
        return len;
    }

    /**
     * 快慢指针解法
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }


    public static void testCase1() {
        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5}); //
        LinkListNodeUtils.print(removeNthFromEnd(listNode, 2)); // 1->2->3->5->null

        ListNode listNode1 = LinkListNodeUtils.get(new int[]{1, 2});
        LinkListNodeUtils.print(removeNthFromEnd2(listNode1, 2));
    }

    public static void testCase2() {
        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5}); //
        LinkListNodeUtils.print(removeNthFromEnd2(listNode, 2)); // 1->2->3->5->null

        ListNode listNode1 = LinkListNodeUtils.get(new int[]{1, 2});
        LinkListNodeUtils.print(removeNthFromEnd2(listNode1, 2));
    }

    public static void main(String[] args) {
//     testCase1();
        testCase2();
    }

}