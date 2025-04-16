package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 二叉树的直径
 */
public class LeetCode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int ans = 0;

    /**
     * 解题思路 从根节点出发 递归遍历整颗树
     * 对于每个节点：
     * 计算其左子树的最大深度
     * 计算其右子树的最大深度
     * 更新最大直径为 左深度+右深度
     *
     * @param treeNode
     * @return
     */
    public int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left  = dfs(treeNode.left);
        int right = dfs(treeNode.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2});
        System.out.println(new LeetCode543().diameterOfBinaryTree(treeNode));
    }

}