package org.newrain.leetcode.offer;


import java.util.*;

public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            if (pop.left != null) {
                treeNodes.add(pop.left);
            }
            if (pop.right != null) {
                treeNodes.add(pop.right);
            }
            TreeNode right = pop.right;
            pop.right = pop.left;
            pop.left = right;
        }
        return root;
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
