package org.newrain.code.problem.linkedlist;

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
        ListNode small = new ListNode(0);
        ListNode smallHead = small;

        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (head != null) {
            if (head.val > x) {
                large.next = head;
                large = large.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode partition = partition(LinkListNodeUtils.get(new int[]{1, 4, 3, 2, 5, 2}), 3);
        LinkListNodeUtils.print(partition);

    }
}