package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 *
 */
public class LeetCode998 {


    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return dfs(root, val);
    }

    /**
     * 题目要求在一个已存在的最大二叉树中插入新值 val（添加到原数组末尾），并返回重构后的新最大二叉树。
     * 关键在于理解最大二叉树的构建规则，并找到插入新值的正确位置。
     * ->添加到原数组末尾 意味着只影响右子树
     * <p>
     * 从根节点出发：
     * <p>
     * 如果当前节点值 < 新值 val：
     * 新值成为当前节点的父节点，原树挂在新节点的左下方。
     * <p>
     * 如果当前节点值 > 新值 val：
     * 继续向右子树查找插入位置（因为新值在原数组末尾，只能影响右侧分支）。
     * <p>
     * 递归终止条件：
     * <p>
     * 遇到空节点（说明到达最右侧末端），直接插入新值。
     * <p>
     * 遇到比新值小的节点，新值“挤掉”它成为父节点。
     *
     * @param treeNode
     * @param val
     * @return
     */
    public TreeNode dfs(TreeNode treeNode, int val) {
        if (treeNode == null || val > treeNode.val) {
            TreeNode node = new TreeNode(val);
            node.left = treeNode;
            return node;
        }
        System.out.println("当前节点值：" + treeNode.val);
        treeNode.right = dfs(treeNode.right, val); // 递归调用 更新当前节点的右节点
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 2, 4, null, 1});
        System.out.println(new LeetCode998().insertIntoMaxTree(treeNode, 3));
    }
}