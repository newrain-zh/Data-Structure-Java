package org.newrain.leetcode.practise.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LeetCode876 {

    public ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tail = head;
        while (tail.next != null) {
            list.add(tail);
            tail = tail.next;
        }
        int pos = list.size() / 2;
        if ((list.size() & 1) != 0) {
            return list.get(pos);
        }
        return list.get(pos + 1);

    }

    public static void main(String[] args) {
        System.out.println(7/2);
    }


}
