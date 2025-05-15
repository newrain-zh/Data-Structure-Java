package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode965. 单值二叉树
 * <a href="https://leetcode.cn/problems/univalued-binary-tree/">...</a>
 */
public class LeetCode965 {


    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    public boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val == val) {
            boolean left = dfs(root.left, val);
            boolean dfs = dfs(root.right, val);
            return left && dfs;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode965().isUnivalTree(TreeNodeUtils.buildTree(new Integer[]{1, 1, 1, 1, 1, null, 1})));
        System.out.println(new LeetCode965().isUnivalTree(TreeNodeUtils.buildTree(new Integer[]{2, 2, 2, 5, 2})));
    }
}