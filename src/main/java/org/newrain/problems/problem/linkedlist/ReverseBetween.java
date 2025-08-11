package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class ReverseBetween {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;

        // 虚拟头结点，方便处理 m=1 的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1. 找到 m 位置的前一个节点 pre
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        // 2. 开始反转区间
        ListNode curr = pre.next; // 第 m 个节点
        ListNode next;
        for (int i = 0; i < n - m; i++) {
            next      = curr.next;         // 取出 curr 后                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             面的节点
            curr.next = next.next;    // 断开 curr 和 next 的连接
            next.next = pre.next;     // 把 next 插到 pre 的后面
            pre.next  = next;          // pre 指向 next
        }

        return dummy.next;
    }

    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || m == n) return head;

        // 1. 存入数组
        java.util.List<ListNode> list = new java.util.ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        // 2. 反转 m 到 n 之间的节点（m 和 n 是 1-based）
        int left = m - 1, right = n - 1;
        while (left < right) {
            ListNode temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }

        // 3. 重新连接链表
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;

        return list.get(0);
    }

    public static void main(String[] args) {
//        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5});
//        LinkListNodeUtils.print(reverseBetween1(listNode, 2, 4));

/*        ListNode listNode = LinkListNodeUtils.get(new int[]{5});
        LinkListNodeUtils.print(reverseBetween(listNode, 1, 1));*/

        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3});
        LinkListNodeUtils.print(reverseBetween1(listNode, 1, 2)); // 2->1-> 3
    }
}