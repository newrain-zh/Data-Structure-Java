package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

/**
 * LeetCode.687 最长同值路径
 */
public class LeetCode687 {

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    public int maxPath = 0;

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 对于每个节点，计算其左右子树中与当前节点值相同的最长路径长度
        int left  = dfs(node.left);
        int right = dfs(node.right);
        // 计算当前节点的左右有效路径长度
        // 若当前节点与左右子节点值相同，则合并左右路径形成更长的路径，并更新全局最大值。
        int leftPath = 0;
        if (node.left != null && node.left.val == node.val) {
            leftPath = left + 1; // 左子节点与当前节点值相同，路径延长
        }

        int rightPath = 0;
        if (node.right != null && node.right.val == node.val) {
            rightPath = right + 1; // 右子节点与当前节点值相同，路径延长
        }

        // 更新全局最大值：当前节点连接左右路径的总长度
        maxPath = Math.max(maxPath, leftPath + rightPath);

        // 返回当前节点能提供的最大单侧路径长度
        return Math.max(leftPath, rightPath);
    }
}