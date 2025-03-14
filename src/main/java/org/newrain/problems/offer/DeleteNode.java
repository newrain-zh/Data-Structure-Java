package org.newrain.problems.offer;

public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (val == head.val) {
            return head.next;
        }
        //记录要删除节点的上一个节点
        ListNode pre = head;
        ListNode cur = head.next;
        //找到被删除的节点
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return pre;
    }

    public ListNode deleteNode1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode curr = dumpNode;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return dumpNode.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}