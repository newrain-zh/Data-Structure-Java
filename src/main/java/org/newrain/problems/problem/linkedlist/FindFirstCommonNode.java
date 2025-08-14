package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;

public class FindFirstCommonNode {


    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 边界条件判断
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        // 初始化两个指针，分别指向两个链表的头节点
        ListNode pA = pHead1;
        ListNode pB = pHead2;

        // 当两个指针不相等时继续遍历
        while (pA != pB) {
            // 若pA未到达链表尾则后移，否则切换到另一个链表的头
            pA = (pA == null) ? pHead2 : pA.next;
            // 若pB未到达链表尾则后移，否则切换到另一个链表的头
            pB = (pB == null) ? pHead1 : pB.next;
        }

        // 若有公共节点则返回该节点，否则返回null
        return pA;
    }
}