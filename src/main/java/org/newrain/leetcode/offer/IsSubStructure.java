package org.newrain.leetcode.offer;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return false;
    }

    private boolean eq(TreeNode a, TreeNode b) {
        if (a.val == b.val) {
            return true;
        }

        return false;
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
