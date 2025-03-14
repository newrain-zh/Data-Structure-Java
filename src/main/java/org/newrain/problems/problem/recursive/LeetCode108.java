package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;

/**
 * @author NewRain
 */
public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        LeetCode108 leetCode108 = new LeetCode108();
        leetCode108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

}