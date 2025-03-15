package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 合并二叉树
 *
 * @author NewRain
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/description/">...</a>
 */
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        return dfs(root1, root2);
    }

    public static TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = dfs(root1.left, root2.left);
        treeNode.right = dfs(root1.right, root2.right);
        return treeNode;
    }

    public static void main(String[] args) {
/*        TreeNode treeNode1 = TreeNodeUtils.buildTree(new Integer[]{1, 3, 2, 5});
        TreeNode treeNode2 = TreeNodeUtils.buildTree(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode treeNode = new LeetCode617().mergeTrees(treeNode1, treeNode2);
        TreeNodeUtils.printTree(treeNode);*/


        TreeNode treeNode1 = TreeNodeUtils.buildTree(new Integer[]{1});
        TreeNode treeNode2 = TreeNodeUtils.buildTree(new Integer[]{1, 2});
        TreeNode treeNode = new LeetCode617().mergeTrees(treeNode1, treeNode2);
        TreeNodeUtils.printTree(treeNode);
    }
}