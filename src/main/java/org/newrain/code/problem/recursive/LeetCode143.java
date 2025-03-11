package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.ListNode;
import org.newrain.code.problem.utils.LinkListNodeUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/reorder-list/">...</a>
 */

public class LeetCode143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        List<ListNode> objects = new ArrayList<>();
        dfs(head, objects);
//        LinkListNodeUtils.print(head);

        int size = objects.size() / 2;
        int pos = objects.size() - 1;

        // 先将第一位和最后一位先连接
        // 例如：1->2->3->4->5
        // 先将 1->5 更新前驱节点 prevNode = 5 这样遍历链表时，prev.next 指向前半部分节点
        ListNode prev = head; // 前驱节点 先指向链表头部
        prev.next = objects.get(pos); // 将当前节点的next指向后半部分链表的头节点
        pos--;
        prev = prev.next; // 前驱节点更新

        for (int i = 1; i < size; i++) {
            ListNode currentNode = objects.get(i); // 当前节点
            currentNode.next = objects.get(pos); // 将当前节点的next指向后半部分链表的头节点
            pos--;  // 后半部分链表头节点后移
            prev.next = currentNode;
            prev = currentNode.next;

        }
        if (objects.size() % 2 == 1) { // 链表个数为奇数时，需要将中间节点指向后半部分链表的头节点
            objects.get(size + 1).next = objects.get(size);
        }
        System.out.println("====");
        LinkListNodeUtils.print(head);
    }

    public ListNode dfs(ListNode head, List<ListNode> list) {
        if (head == null) {
            return null;
        }
        list.add(head);
        dfs(head.next, list);
        head.next = null;
        return head;
    }


    /**
     * 寻找链表中点：使用快慢指针确定链表的中间节点，将链表分为前后两半。
     * 反转后半部分：将后半部分链表反转，以便后续交替合并。
     * 合并链表：将前半部分和反转后的后半部分交替合并，形成新的链表。
     */
    public void reorderList1(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        dfs(head, listNodes);
        int len = listNodes.size();
        int half = len / 2;
        List<ListNode> before = new ArrayList<>(half);
        List<ListNode> after = new ArrayList<>(half);
        for (int i = 0; i < listNodes.size(); i++) {
            if (i >= half) {
                after.add(listNodes.get(i));
            } else {
                before.add(listNodes.get(i));
            }
        }
        int pos = after.size() - 1;
        for (int i = 0; i < before.size(); i++) {
            ListNode prevNode = before.get(i);
            ListNode nextNode = after.get(pos);
            prevNode.next = nextNode;
            if (i + 1 < before.size()) {
                nextNode.next = before.get(i + 1);
            }
            pos--;
        }
        if (len % 2 == 1) { // 奇数数组
            after.get(1).next = after.get(0);
        }
        LinkListNodeUtils.print(head);
    }

    public static void main(String[] args) {
        new LeetCode143().reorderList1(LinkListNodeUtils.get(new int[]{1, 2, 3}));
        new LeetCode143().reorderList1(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5})); // [1,5,2,4,3]
        new LeetCode143().reorderList1(LinkListNodeUtils.get(new int[]{1, 2, 3, 4})); // 1 4 2 3
        new LeetCode143().reorderList1(LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5, 6, 7})); //[1,7,2,6,3,5,4]
    }

}