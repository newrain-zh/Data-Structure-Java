package org.newrain.code.problem.tree;

/**
 * leetcode
 * @link <a href="https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/description/">...</a>
 * LCR 175. 计算二叉树的深度
 */
public class CalculateDepth {

    public int calculateDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = calculateDepth(root.left);
        int right = calculateDepth(root.right);
        return Math.max(left, right) + 1;
    }
}