package org.newrain.leetcode.problem.tree;

import java.util.*;

public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<Integer> list;
        while (!deque.isEmpty()) {
            int size = deque.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                list.add(pop.val);
                if (pop.left != null) {
                    deque.add(pop.left);
                }
                if (pop.right != null) {
                    deque.add(pop.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
