package org.newrain.example.Tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

public class Tree {


    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println("preOrder=" + treeNode.val);
        preOrder(treeNode.left);
        System.out.println("inOrder=" + treeNode.val);
        preOrder(treeNode.right);
        System.out.println("postOrder=" + treeNode.val);
    }


    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println("inOrder=" + treeNode.val);
        inOrder(treeNode.right);
    }

    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        System.out.println("before=" + treeNode.val);
        postOrder(treeNode.right);
        System.out.println("after=" + treeNode.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        TreeNodeUtils.printTree(treeNode);
        preOrder(treeNode);
        System.out.println("=================");
//        postOrder(treeNode);

    }


}