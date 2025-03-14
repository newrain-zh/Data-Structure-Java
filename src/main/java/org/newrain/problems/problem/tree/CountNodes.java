package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

/**
 * leetcode.222 完全二叉树的节点个数
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class CountNodes {

    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        System.out.println("left=" + left);
        int right = countNodes(root.right);
        System.out.println("right=" + right);
        return left + right + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        System.out.println(countNodes(treeNode));
    }
}