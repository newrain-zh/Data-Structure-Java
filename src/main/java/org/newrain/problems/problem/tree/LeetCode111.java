package org.newrain.problems.problem.tree;
import org.newrain.problems.problem.common.TreeNode;
public class LeetCode111 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return l + r + 1;
        }
        return Math.min(l, r) + 1;

    }
}