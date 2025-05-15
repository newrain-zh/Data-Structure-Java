package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * leetcode.86 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class Partition {

    /**
     * 使用两个链表存储比x大、比x小的值
     * 然后拼接两个链表就得到题目中的答案
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0); // 小于 x 的链表虚拟头
        ListNode largeDummy = new ListNode(0); // 大于等于 x 的链表虚拟头

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next = null; // 断开 large 链表尾部，避免可能成环
        small.next = largeDummy.next; // 拼接两个链表

        return smallDummy.next;
    }

    public static void main(String[] args) {
        ListNode partition = partition(LinkListNodeUtils.get(new int[]{1, 4, 3, 2, 5, 2}), 3);
        LinkListNodeUtils.print(partition);

    }
}