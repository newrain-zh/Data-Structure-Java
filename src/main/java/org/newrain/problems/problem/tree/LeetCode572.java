package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 572.另一颗树的子树
 * <a href="https://leetcode.cn/problems/subtree-of-another-tree">...</a>
 */
public class LeetCode572 {


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    public static void testCase1() {
        LeetCode572 leetCode572 = new LeetCode572();
        TreeNode root = TreeNodeUtils.buildTree(new Integer[]{3, 4, 5, 1, 2});
        TreeNode subRoot = TreeNodeUtils.buildTree(new Integer[]{4, 1, 2});
        System.out.println(leetCode572.isSubtree(root, subRoot));
    }

    public static void testCase2() {
        LeetCode572 leetCode572 = new LeetCode572();
        TreeNode root = TreeNodeUtils.buildTree(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
        TreeNode subRoot = TreeNodeUtils.buildTree(new Integer[]{4, 1, 2});
        System.out.println(leetCode572.isSubtree(root, subRoot));
    }


    public static void main(String[] args) {
        testCase1();
        testCase2();
    }
}