package org.newrain.leetcode.offer;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    public boolean help(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return help(left.right, right.left) && help(left.left, right.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
