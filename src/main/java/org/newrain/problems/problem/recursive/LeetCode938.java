package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 938. 二叉搜索树的范围和
 *
 * @author NewRain
 * <a href="https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/">...</a>
 */
public class LeetCode938 {


    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public int sum = 0;

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }


    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val > low) {
            sum += rangeSumBST1(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val < high) {
            sum += rangeSumBST1(root.right, low, high);
        }
        return sum;
    }


    public int dfs1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        System.out.println("sum=" + sum);
        sum += dfs1(root.left, low, high);
        sum += dfs1(root.right, low, high);
        return sum;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{10, 5, 15, 3, 7, null, 18});
        System.out.println(new LeetCode938().rangeSumBST(treeNode, 7, 15));
        System.out.println(new LeetCode938().rangeSumBST1(treeNode, 7, 15));
        System.out.println(new LeetCode938().dfs1(treeNode, 7, 15));

    }
}