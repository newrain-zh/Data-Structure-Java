package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode.1325 删除给定值的叶子节点
 */
public class LeetCode1325 {


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    /**
     * 用后序遍历的方式，这样叶子节点首先做处理
     * 左->右->根
     * 删除叶子节点返回 null 值 递进处理方便
     */
    public TreeNode dfs(TreeNode treeNode, int target) {
        if (treeNode == null) {
            return null;
        }
        treeNode.left  = dfs(treeNode.left, target);
        treeNode.right = dfs(treeNode.right, target);
        if (treeNode.left == null && treeNode.right == null) { // 当前为根节点且等于目标值
            if (treeNode.val == target) {
                return null;
            }
        }
        return treeNode;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 2, null, 2, 4});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 3, 3, 3, 2});
        new LeetCode1325().removeLeafNodes(treeNode, 2);
        TreeNodeUtils.printTree(treeNode);


    }
}