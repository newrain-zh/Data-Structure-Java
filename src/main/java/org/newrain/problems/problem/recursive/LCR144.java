package org.newrain.problems.problem.recursive;


import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/">...</a>
 */
public class LCR144 {
    public static TreeNode flipTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNodeUtils.print(root);
        System.out.println("反转之前");
        TreeNode left = mirrorTree(root.left); // 交换 root的左边节点
        TreeNode right = mirrorTree(root.right); // 交换 root的右边节点
        root.left = right;
        root.right = left;
        TreeNodeUtils.print(root);
        System.out.println("反转之后");
        return root;
    }

    public static TreeNode mirrorTree(TreeNode node) {
        if (node != null) {
            System.out.println("交换前：" + node.val);
            node.left = mirrorTree(node.left);
            node.right = mirrorTree(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

       /* TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);*/
        flipTree(root);

    }


}