package org.newrain.code.problem.linkedlist;


/**
 * @author NewRain
 * @description 相交链表
 * @link <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">leetcode</a>
 * @complexity middle
 */
public class LeetCode160 {


    /**
     * 情况1：链表相交
     * 假设链表结构如下：
     * <p>
     * 链表A：A1 → A2 → C1 → C2 → C3
     * <p>
     * 链表B：B1 → B2 → B3 → C1 → C2 → C3
     * <p>
     * 相交节点为 C1。
     * <p>
     * 指针移动过程：
     * <p>
     * pA 从 A1 出发，走到 C3（末尾）后跳转到 B1。
     * <p>
     * pB 从 B1 出发，走到 C3（末尾）后跳转到 A1。
     * <p>
     * 此时：
     * <p>
     * pA 的路径：A1 → A2 → C1 → C2 → C3 → B1 → B2 → B3 → C1
     * <p>
     * pB 的路径：B1 → B2 → B3 → C1 → C2 → C3 → A1 → A2 → C1
     * <p>
     * 两者在 C1 相遇。
     * <p>
     * 情况2：链表不相交
     * 假设链表结构如下：
     * <p>
     * 链表A：A1 → A2 → A3 → null
     * <p>
     * 链表B：B1 → B2 → null
     * <p>
     * 指针移动过程：
     * <p>
     * pA 遍历路径：A1 → A2 → A3 → null → B1 → B2 → null
     * <p>
     * pB 遍历路径：B1 → B2 → null → A1 → A2 → A3 → null
     * <p>
     * 两者最终同时指向 null，返回 null。
     * <p>
     * 无论是否相交，两个指针最终走过的总步数均为 a + b。
     * <p>
     * 当它们第二次走到末尾时，会同时指向 null，此时 pA == pB 条件成立，循环终止。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next; // A链表走完，则从B链表开始
            pB = pB == null ? headA : pB.next; // B链表走完，则从A链表开始
        }
        return pA;
    }

    /**
     * 将两个链表长度变为一样，然后一起遍历 找到第一个相同的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lA = getLength(headA);
        int lB = getLength(headB);
        if (lA > lB) {
            headA = moveToPos(headA, lA - lB);
        } else {
            headB = moveToPos(headB, lB - lA);
        }
        ListNode res = null;

        while (headA != null && headB != null) {
            if (headA == headB) {
                res = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return res;
    }


    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode moveToPos(ListNode head, int pos) {
        int step = 0;
        while (head != null) {
            if (step == pos) {
                return head;
            }
            step++;
            head = head.next;
        }
        return null;
    }


}