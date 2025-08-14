package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

import java.util.Stack;

public class AddInList {


    public static ListNode addInList(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        int      carry  = 0;
        ListNode result = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry!=0) {
            int a   = stack1.isEmpty() ? 0 : stack1.pop().val;
            int b   = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = a + b + carry;
            carry = sum / 10;
            int currentVal = sum % 10;

            // 头插法构建结果链表（因为我们是从低位开始计算的）
            ListNode newNode = new ListNode(currentVal);
            newNode.next = result;
            result       = newNode;
        }
        return result;

    }

    public static void main(String[] args) {
//        LinkListNodeUtils.print(addTwoNumbers(LinkListNodeUtils.get(new int[]{9, 3, 7}), LinkListNodeUtils.get(new int[]{6, 3})));
//        LinkListNodeUtils.print(addTwoNumbers(LinkListNodeUtils.get(new int[]{0}), LinkListNodeUtils.get(new int[]{6, 3})));
        LinkListNodeUtils.print(addInList(LinkListNodeUtils.get(new int[]{5, 9, 7, 5, 7, 1, 2, 6, 4, 2, 7, 8, 9, 6, 1, 6, 6, 1, 1, 4, 2, 9, 5, 5, 0, 4, 6, 3, 0, 4, 3, 5, 6, 7, 0, 5, 5, 4, 4, 0}),
                LinkListNodeUtils.get(new int[]{1, 3, 2, 5, 0, 6, 0, 2, 1, 4, 3, 9, 3, 0, 9, 9, 0, 3, 1, 6, 5, 7, 8, 6, 2, 3, 8, 5, 0, 9, 7, 9, 4, 5, 9, 9, 4, 9, 3, 6})));
    }


    /**
     * 计算两个链表表示的整数之和
     *
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return 结果链表
     */
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // 创建哑节点作为结果链表的起始点，简化边界处理
        ListNode dummy   = new ListNode(0);
        ListNode current = dummy;
        int      carry   = 0; // 进位值

        // 遍历两个链表，直到两个链表都结束且没有进位
        while (head1 != null || head2 != null || carry != 0) {
            // 获取当前节点的值，若链表已结束则用0代替
            int val1 = (head1 != null) ? head1.val : 0;
            int val2 = (head2 != null) ? head2.val : 0;

            // 计算当前位的总和（包括进位）
            int sum = val1 + val2 + carry;

            // 计算当前位的结果和新的进位
            carry = sum / 10;
            int currentVal = sum % 10;

            // 创建新节点并移动当前指针
            current.next = new ListNode(currentVal);
            current      = current.next;

            // 移动输入链表的指针（如果存在）
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        // 哑节点的下一个节点就是结果链表的头节点
        return dummy.next;
    }
}