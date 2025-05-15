package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * 删除中间节点
 */
public class LeetCode2095 {

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null){
            return null;
        }
        int      count = 0;
        ListNode dummy = head;
        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }
        int mid = count / 2;
        dummy = head;
        count = 0;
        ListNode prev = dummy;
        while (dummy != null) {
            count++;
            if (count == mid) {
                System.out.println("prev:" + prev.val);
                prev.next = dummy.next.next;
                break;
            }
            dummy = dummy.next;
            prev  = dummy;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode listNode = deleteMiddle(LinkListNodeUtils.get(new int[]{1, 3, 4, 7, 1, 2, 6})); // 1,3,4,1,2,6
//        ListNode listNode = deleteMiddle(LinkListNodeUtils.get(new int[]{1, 2, 3, 4})); // [1,2,4]
        ListNode listNode = deleteMiddle(LinkListNodeUtils.get(new int[]{2, 1})); // [1,2,4]
        LinkListNodeUtils.print(listNode);
    }

}