package org.newrain.leetcode.practise.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LeetCode19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        if (list.size() == 1) {
            return null;
        }
        int pos = list.size() - n;
        ListNode deleteNode = list.get(pos);
        //[1,2] 1
        if (pos - 1 >= 0) {
            ListNode prev = list.get(pos - 1);
            prev.next = deleteNode.next;
            return list.get(0);
        } else {
            return list.get(1);
        }
    }

}
