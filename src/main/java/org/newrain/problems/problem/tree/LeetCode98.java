package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

public class LeetCode98 {

    static int preVal = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= preVal) {
            return false;
        }
        preVal = root.val;
        return isValidBST(root.right);
    }

}