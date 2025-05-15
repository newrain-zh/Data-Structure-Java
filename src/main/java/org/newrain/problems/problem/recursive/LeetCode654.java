package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">...</a>
 */
public class LeetCode654 {

    /**
     * 递归构建：每次递归处理一个子数组，找到当前子数组的最大值作为根节点。
     * <p>
     * 分治策略：
     * <p>
     * 确定根节点：在子数组中找到最大值及其索引。
     * <p>
     * 分割左右子数组：最大值左边的子数组构建左子树，右边的子数组构建右子树。
     * <p>
     * 终止条件：当子数组范围无效（起始索引大于结束索引）时返回null。
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = findMaxIndex(start, end, nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        TreeNode left = buildTree(nums, start, maxIndex - 1);
        TreeNode right = buildTree(nums, maxIndex + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }


    public int findMaxIndex(int start, int end, int[] nums) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new LeetCode654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        TreeNodeUtils.printTree(treeNode);
    }
}