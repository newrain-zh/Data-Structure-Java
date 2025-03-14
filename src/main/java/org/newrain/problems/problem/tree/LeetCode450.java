package org.newrain.problems.problem.tree;
public class LeetCode450 {
    TreeNode prev;
    public TreeNode deleteNode(TreeNode root, int key) {
        prev = root;
        return null;
    }



    public void dfs(TreeNode root, int key) {
        if (root.val == key) {

        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}