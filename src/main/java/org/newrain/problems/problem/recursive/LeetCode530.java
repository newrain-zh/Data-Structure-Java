package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 530. 二叉搜索树中的最小绝对差
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/">...</a>
 */
public class LeetCode530 {

    // TODO 直接在 dfs中计算出差值
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i + 1) - list.get(i);
            if (min > diff) {
                min = diff;
            }
        }
        return min;
    }

    public static void dfs(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, list);
        list.add(treeNode.val);
        dfs(treeNode.right, list);
    }

}