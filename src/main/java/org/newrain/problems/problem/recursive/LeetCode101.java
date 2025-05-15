package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/symmetric-tree/?envType=problem-list-v2&envId=nwEI8Rqc">...</a>
 */
public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}