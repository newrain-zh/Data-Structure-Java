package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.TreeNode;
import org.newrain.code.problem.utils.TreeNodeUtils;

/**
 * 路径总和
 * <a href="https://leetcode.cn/problems/path-sum/">...</a>
 */
public class LeetCode112 {

    // TODO 层序遍历如何解决该问题
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    /**
     * 递归解法
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) { // 检查叶子节点是否满足条件
            return root.val == targetSum;
        }
        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(new LeetCode112().hasPathSum(treeNode, 22));
    }

}