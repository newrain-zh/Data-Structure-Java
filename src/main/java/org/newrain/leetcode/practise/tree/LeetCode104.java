package org.newrain.leetcode.practise.tree;

/**
 * 树的最大深度
 *
 * @author newrain
 */
public class LeetCode104 {

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
