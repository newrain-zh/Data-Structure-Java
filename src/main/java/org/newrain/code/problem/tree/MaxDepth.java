package org.newrain.code.problem.tree;

/**
 * leetcode.104 树的最大深度
 * @author newrain
 * @description 树的最大深度
 * @link <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">...</a>
 * @tag 树
 * @complexity easy
 */
public class MaxDepth {

    int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}