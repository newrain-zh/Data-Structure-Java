package org.newrain.leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        List<Integer> list = new ArrayList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                list.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                list.add(l2.val);
                l2 = l2.next;
            }
        }
        Collections.sort(list);
        int size = list.size();
        List<ListNode> listNodeList = new ArrayList<>(size);
        for (Integer integer : list) {
            listNodeList.add(new ListNode(integer));
        }
        for (int i = 0; i < size; i++) {
            if (i != listNodeList.size() - 1) {
                listNodeList.get(i).next = listNodeList.get(i + 1);
            }
        }
        return listNodeList.get(0);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
