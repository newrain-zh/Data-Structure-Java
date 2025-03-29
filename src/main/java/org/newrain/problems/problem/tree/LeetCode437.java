package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 */
public class LeetCode437 {


    private int             count          = 0;
    private int             targetSum;
    private Map<Long, Long> prefixSumCount = new HashMap<>();

    /**
     * 前缀和解题思路
     * TODO 这个 map真的需要吗
     */
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        prefixSumCount.put(0L, 1L);
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return;
        }
        currentSum += node.val;
        count += prefixSumCount.getOrDefault(currentSum - targetSum, 0L);
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0L) + 1L);
        dfs(node.left, currentSum);
        dfs(node.right, currentSum);
        // 回溯处理 不干扰其他路径
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        // 这里代表当前路径已经计算完成了，
        if (prefixSumCount.get(currentSum) == 0) {
            prefixSumCount.remove(currentSum);
        }

    }

    public static void main(String[] args) {
        LeetCode437 leetCode437 = new LeetCode437();
        TreeNode    treeNode    = TreeNodeUtils.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        System.out.println(leetCode437.pathSum(treeNode, 8));
    }
}