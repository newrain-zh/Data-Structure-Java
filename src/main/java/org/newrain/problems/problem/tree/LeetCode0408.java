package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

/**
 * 首个共同祖先（LCA）
 */
public class LeetCode0408 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // p 、q 必定会存在 root上
            return root;
        }
        TreeNode left  = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left != null && right != null) { // 如果左右子树不为空 那当前节点是 LCA
            return root;
        }
        return left != null ? left : right; // 返回不未空的子树
    }
}