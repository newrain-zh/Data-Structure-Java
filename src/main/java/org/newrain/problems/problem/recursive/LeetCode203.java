package org.newrain.problems.problem.recursive;


import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * LeetCode 203. 删除链表中的节点
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">...</a>
 */
public class LeetCode203 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }// 6.next = null
        head.next = removeElements(head.next, val); // 递归处理子链表
        LinkListNodeUtils.print(head);
        return head.val == val ? head.next : head;
    }

    /**
     * 递归调用栈：
     * 调用栈1：head=1 → 2 → 3 → 2 → null
     * 调用栈2：head=2 → 3 → 2 → null
     * 调用栈3：head=3 → 2 → null
     * 调用栈4：head=2 → null
     * 调用栈5：head=null（基线条件）
     * <p>
     * <p>
     * 逐层返回
     * 调用栈5：返回 null。
     * 调用栈4：head=2，满足删除条件，返回后续处理结果 null。
     * 调用栈3：head=3，保留当前节点，递归结果 head.next = null，返回 3 → null。
     * 调用栈2：head=2，满足删除条件，直接返回 3 → null。
     * 调用栈1：head=1，保留当前节点，递归结果 head.next = 3 → null，返回 1 → 3 → null。
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        LinkListNodeUtils.print(head);
        if (head.val == val) {
            // 当前节点需删除，直接返回后续处理结果
            return removeElements1(head.next, val);
        } else {
            // 当前节点保留，递归处理后续链表并连接
            head.next = removeElements1(head.next, val);
        }
        return head;

    }


    public static void main(String[] args) {
     /*   ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 6, 3, 4, 5, 6});
        removeElements(listNode, 6);
        System.out.println("=====");*/
        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3, 2});
        LinkListNodeUtils.print(removeElements1(listNode, 2));

/*        ListNode listNode = LinkListNodeUtils.get(new int[]{7, 7, 7, 7});
        removeElements(listNode, 7);*/

    }
}