package org.newrain.code.problem.linkedlist;


import org.newrain.code.problem.common.ListNode;
import org.newrain.code.problem.utils.LinkListNodeUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode.148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode dump = head;
        while (dump != null) {
            list.add(dump);
            dump = dump.next;
        }
        for (ListNode listNode : list) {
            listNode.next = null; //断开链表
        }
        list.sort(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < list.size() - 1; i++) {
            ListNode curr = list.get(i);
            if (i != list.size() - 1) { //不是最后一个节点
                curr.next = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode listNode = sortList(LinkListNodeUtils.get(new int[]{4, 2, 1, 3}));
        LinkListNodeUtils.print(listNode);

    }

}