package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

public class LeetCode814 {


    /**
     * 根据题目的意思是删除值为 0 的叶子节点
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left  = dfs(root.left);
        root.right = dfs(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode    treeNode    = TreeNodeUtils.buildTree(new Integer[]{1, null, 0, 0, 1});
        LeetCode814 leetCode814 = new LeetCode814();
        TreeNode    res1        = leetCode814.pruneTree(treeNode);
        TreeNodeUtils.printTree(res1);

    }
}