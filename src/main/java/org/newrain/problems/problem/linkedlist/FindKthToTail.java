package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class FindKthToTail {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public static ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null) return null;
        if (k <= 0) {
            return null;
        }
        ListNode dummy = pHead;
        int      len   = 0;
        while (dummy != null) {
            dummy = dummy.next;
            len++;
        }
        if (k > len) {
            return null;
        }
        int pos = len - k;
        if (pos == 0) {
            return pHead;
        }
        int      step   = 1;
        ListNode dummy1 = pHead;
        while (step != pos) {
            dummy1 = dummy1.next;
            step++;
        }
        return dummy1.next;
    }

    public static void main(String[] args) {
        LinkListNodeUtils.print(findKthToTail(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5}), 2)); // 4 5
        LinkListNodeUtils.print(findKthToTail(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5, 6}), 6)); //
        LinkListNodeUtils.print(findKthToTail(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5}), 0)); // null

    }
}