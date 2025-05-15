package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;


/**
 * @author newRain
 * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/">...</a>
 * 700. 二叉搜索树中的搜索
 */
public class LeetCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        dfs(root, val);
        return res;
    }

    TreeNode res = null;

    /**
     * 前序遍历 根->左->右
     * 这样的顺序查找到指定值就可以直接返回其子树
     *
     * @param treeNode
     * @param val
     */
    public void dfs(TreeNode treeNode, int val) {
        if (treeNode == null || res != null) { // 如果找到了就不再递归了
            return;
        }
        if (treeNode.val == val) {
            res = treeNode;
        } else {
            dfs(treeNode.left, val);
            dfs(treeNode.right, val);
        }
    }


    public static void main(String[] args) {
        LeetCode700 leetCode700 = new LeetCode700();
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{4, 2, 7, 1, 3});
        TreeNodeUtils.printTree(leetCode700.searchBST(treeNode, 1));
    }
}