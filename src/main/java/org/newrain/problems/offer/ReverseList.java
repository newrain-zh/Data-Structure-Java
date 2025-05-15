package org.newrain.problems.offer;


import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;


/**
 * 反转链表
 * 输入 2->4->5->null
 * 输出 null->5->4->2
 * <p>
 * null<-2<-4<-5
 *
 * @author NewRain
 * @description 反转链表
 * @link <a href="https://leetcode.cn/problems/UHnkqh/">...</a>
 */
public class ReverseList {

    /**
     * 循环解法
     *
     * @param head 原始链表
     * @return 反转之后的链表
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //4
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归解法
     * 此处的递归比较好理解 每层递归处理的节点
     *
     * @param head 原始链表
     * @return 反转之后的链表
     * @link <a href="https://leetcode.cn/problems/UHnkqh/solution/jian-zhi-offer-ii-024-fan-zhuan-lian-bia-m8go/">...</a>
     */
    public static ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private static ListNode reverse(ListNode pre, ListNode cur) {
        //当前节点为null时，退出
        if (cur == null) {
            return pre;
        }
        //保存当前节点的下一个节点
        ListNode next = cur.next;
        //设当前节点的下一个节点为当前节点的上一个节点
        cur.next = pre;
        //递归，反转当前节点和下一个节点
        return reverse(cur, next);
    }

    public static void main(String[] args) {
        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3});
        LinkListNodeUtils.print(reverseList2(listNode));

    }
}