package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode.236 二叉树的最近公共祖先
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root; // 找到了 直接返回当前节点，如果到了叶子节点还没找到直接返回 null
        }
        TreeNode left  = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        System.out.println("curr=" + root.val + ",left=" + left + ",right=" + right);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p        = new TreeNode(0);
        TreeNode q        = new TreeNode(8);
        new LeetCode236().lowestCommonAncestor(treeNode, p, q);
    }

}