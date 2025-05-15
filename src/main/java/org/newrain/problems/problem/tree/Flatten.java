package org.newrain.problems.problem.tree;
import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * leetcode.114 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten {


    public static void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将当前节点的右子树连接到左子树的最右侧节点
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            System.out.println("-----");
            TreeNodeUtils.printTree(root);
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        flatten(treeNode);
        TreeNodeUtils.printTree(treeNode);
    }
}