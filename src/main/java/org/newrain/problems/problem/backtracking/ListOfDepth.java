package org.newrain.problems.problem.backtracking;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 面试题 04.03. 特定深度节点链表
 */
public class ListOfDepth {

    public static ListNode[] listOfDepth(TreeNode tree) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(tree);
        List<ListNode> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            int      size = deque.size();
            ListNode prev = new ListNode(-1);
            ListNode p    = prev;
            for (int i = 0; i < size; i++) {
                TreeNode pop      = deque.pop();
                ListNode currNode = new ListNode(pop.val);
                prev.next = currNode;
                prev      = currNode;
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }

            }
            list.add(p.next);
        }
        ListNode[] ret = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        listOfDepth(TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 7, 8}));
    }

}