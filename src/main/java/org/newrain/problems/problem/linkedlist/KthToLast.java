package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

/**
 * 链表倒数第 K 个元素
 */
public class KthToLast {

    int deep = 0;
    int targetDeep;

    public int kthToLast(ListNode head, int k) {
        this.targetDeep = k;
        return dfs(head);

    }

    public int dfs(ListNode head) {
        if (head == null) {
            return -1;
        }
        int a = dfs(head.next);
        deep++;
        if (deep == targetDeep) {
            return head.val;
        }
        return a;
    }

    public static void main(String[] args) {
        KthToLast kthToLast = new KthToLast();
        ListNode  listNode  = LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5});
        System.out.println(kthToLast.kthToLast(listNode, 2));
    }
}