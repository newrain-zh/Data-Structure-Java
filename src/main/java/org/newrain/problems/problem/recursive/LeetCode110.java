package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">...</a>
 */
public class LeetCode110 {

    public static boolean isBalanced(TreeNode root) {

        return checkHeight(root) != -1;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(rightHeight - leftHeight) > 1) {
            System.out.println("leftHeight:" + leftHeight + ",rightHeight:" + rightHeight);
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1; //// 当前节点高度 = 子树最大高度 + 1
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        TreeNodeUtils.print(root);
        System.out.println(isBalanced(root));

    }

}