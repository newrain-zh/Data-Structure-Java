package org.newrain.problems.offer;

import org.newrain.problems.problem.common.TreeNode;

public class IsBalanced {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        int leftD = depth(root.left);
        int rightD = depth(root.right);
        if (Math.abs(leftD - rightD) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

        public static int depth(TreeNode zroot) {
            if (zroot == null) {
                return 0;
            }
            int leftDepth = depth(zroot.left); //递归
            int rightDepth = depth(zroot.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;

        TreeNode right = new TreeNode(4);
        treeNode.right = right;
        TreeNode right1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(4);
        right.right = right2;
        right.left = right1;
        System.out.println(isBalanced(treeNode));
    }



}