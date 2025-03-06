package org.newrain.code.problem.linkedlist;

import org.newrain.code.problem.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 回文链表
 * @link <a href="https://leetcode.cn/problems/palindrome-linked-list/submissions/">leetcode</a>
 * @link <a href="https://www.lintcode.com/problem/223/">lintcode</a>
 * @complexity easy
 * @tag 递归
 */
public class IsPalindrome {

    /**
     * 双指针+数组
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode dump = head;
        while (dump != null) {
            list.add(dump.val);
            dump = dump.next;
        }
        int low = 0, high = list.size() - 1;
        while (low < high) {
            if (!list.get(low).equals(list.get(high))) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    /**x
     * 递归解法
     */
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }


}