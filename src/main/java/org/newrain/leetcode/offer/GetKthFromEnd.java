package org.newrain.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class GetKthFromEnd {

    /**
     * 将所有节点放入List
     * 倒序节点 我只要找到正序节点的位置就可以了
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }
        return listNodeList.get(listNodeList.size() - k);
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        int size = 0;
        ListNode dumpNode = head;
        while (dumpNode != null) {
            size++;
            dumpNode = dumpNode.next;
        }
        int curr = 0;
        while (head != null) {
            if (curr == size - k) {
                return head;
            }
            curr++;
            head = head.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
