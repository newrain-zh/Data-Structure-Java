package org.newrain.example.structure.tree;

/**
 * @author NewRain
 * @description 二叉树节点
 */
public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    public int getData() {
        return data;
    }


    public TreeNode(int data) {
        this.data = data;
    }


    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
