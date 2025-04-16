package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class LeetCode234 {


    /**
     * 利用数组
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list      = new ArrayList<>();
        ListNode      dummyNode = head;
        while (dummyNode != null) {
            list.add(dummyNode.val);
            dummyNode = dummyNode.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }





}