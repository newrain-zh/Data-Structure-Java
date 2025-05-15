package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 * <a href="https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/">...</a>
 */
public class LeetCode783 {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            if (min > diff) {
                min = diff;
            }
        }
        return min;
    }

    /**
     * 二叉搜索树中序遍历 可以得到一个有序的数组
     *
     * @param treeNode
     * @param list
     */
    public void dfs(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, list);
        list.add(treeNode.val);
        dfs(treeNode.right, list);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{4, 2, 6, 1, 3});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{90, 69, null, 49, 89, null, 52});
        System.out.println(new LeetCode783().minDiffInBST(treeNode));
    }
}