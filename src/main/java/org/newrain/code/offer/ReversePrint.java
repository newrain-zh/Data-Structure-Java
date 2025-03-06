package org.newrain.code.offer;

import org.newrain.code.problem.common.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class ReversePrint {

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        int[] ints = reversePrint(head);
        System.out.println(Arrays.toString(ints));
    }
}