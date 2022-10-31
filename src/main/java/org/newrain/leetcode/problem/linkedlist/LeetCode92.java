package org.newrain.leetcode.problem.linkedlist;

/**
 * 输入 1->2->3->4->5->null
 */
public class LeetCode92 {
    /**
     * 反转链表  2 -4
     * 输入 1 -> 2 -> 3 -> 4 -> 5
     * 输出 1 -> 4 -> 3 -> 2 -> 5
     * 输出 1 -> 2 <- 3 <- 4 -> 5
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for (int i = 0; i < left - 1; i++) {
            g = g.next;
            p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < right - left; i++) {
            //2
            ListNode removed = p.next;
            //2->3
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;

        }
        return dummyHead.next;

    }
}
