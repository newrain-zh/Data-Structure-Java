package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.ListNode;
import org.newrain.code.problem.utils.LinkListNodeUtils;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/add-two-numbers/description/">...</a>
 */
public class LeetCode2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1, l2, 0);
    }


    public static ListNode dfs(ListNode l1, ListNode l2, int carry) {
        // 递归终止条件：两个链表都为空且无进位
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        // 计算当前位的值（处理链表长度不同的情况）
        int val1 = (l1 != null) ? l1.val : 0;
        int val2 = (l2 != null) ? l2.val : 0;
        int sum = val1 + val2 + carry;

        // 创建当前节点
        ListNode node = new ListNode(sum % 10);
        int newCarry = sum / 10;

        // 递归处理下一个节点（自动处理长短链表对齐）
        ListNode next1 = (l1 != null) ? l1.next : null;
        ListNode next2 = (l2 != null) ? l2.next : null;
        node.next = dfs(next1, next2, newCarry);
        return node;
    }

    public static void main(String[] args) {
   /*     ListNode l1 = LinkListNodeUtils.get(new int[]{2, 4, 3});
        ListNode l2 = LinkListNodeUtils.get(new int[]{5, 6, 4});
        LinkListNodeUtils.print(addTwoNumbers(l1, l2));*/
        ListNode l1 = LinkListNodeUtils.get(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = LinkListNodeUtils.get(new int[]{9, 9, 9, 9});
        // 9->9->9->8->9->0->1->null
        // 8,9,9,9,0,0,0,1
        LinkListNodeUtils.print(addTwoNumbers(l1, l2)); // 8,9,9,9,0,0,0,1
        System.out.println(9999999 + 9999); // 10009998
    }
}