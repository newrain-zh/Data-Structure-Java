package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.TreeNode;
import org.newrain.code.problem.utils.TreeNodeUtils;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeNodeUtils.printTree(new LeetCode226().invertTree(treeNode));
    }
}