package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

/**
 * LeetCode.235 二叉搜索树的最近公共祖先
 * p q 如果都大于当前根节点说明在左子树上
 * p q 如果都小于根节点说明都在右子树上
 * 除了以上两种情况 则可能是以下一种情况
 * p q 如果一个小于等于根节点一个大于等于根节点
 * 说明分布在当前节点的两侧 也就是左右子树上
 * 说明当前节点就是最近公共祖先。
 */
public class LeetCode235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (true) {
            if (p.val < ans.val && q.val < ans.val) {
                ans = ans.left;
            } else if (p.val > ans.val && q.val > ans.val) {
                ans = ans.right;
            } else {
                break;
            }
        }
        return ans;
    }

    public TreeNode dfs(TreeNode treeNode, TreeNode p, TreeNode q) {
        if (treeNode == null) {
            return null;
        }
        if (p.val < treeNode.val && q.val < treeNode.val) {
            return dfs(treeNode.left, p, q);
        }

        if (p.val > treeNode.val && q.val > treeNode.val) {
            return dfs(treeNode.right, p, q);
        }
        return treeNode;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left  = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


}