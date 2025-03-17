package org.newrain.problems.problem.tree;


import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode 404. 左叶子之和
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/">...</a>
 */
public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    int sum = 0;

    public void dfs(TreeNode treeNode, int state) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, 1);
        }
        if (treeNode.right != null) {
            dfs(treeNode.right, 2);
        }
        if (treeNode.left == null && treeNode.right == null) { // 是叶子节点
            if (state == 1) {
                sum += treeNode.val;
            }
        }
    }


    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return sumOfLeftLeaves1(root.right);
        } else if (root.left.left == null && root.right.right == null) { // 根节点
            return root.left.val + sumOfLeftLeaves1(root.right);
        } else {
            return sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
        }
    }

    public static void testCase1() {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new LeetCode404().sumOfLeftLeaves(treeNode));
    }

    public static void testCase2() {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(new LeetCode404().sumOfLeftLeaves(treeNode));
    }

    public static void testCase3() {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2});
        System.out.println(new LeetCode404().sumOfLeftLeaves(treeNode));
    }


    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

}