package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;


/**
 * LCR.198 最近公共祖先
 */
public class LCR193 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 后序遍历
        TreeNode left  = lowestCommonAncestor(root.left, p, q); // 递归右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);// 递归左子树
        if (left != null && right != null) { // 说明当前节点就是祖先
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p    = new TreeNode(2);
        TreeNode q    = new TreeNode(4);
        System.out.println(new LCR193().lowestCommonAncestor(root, p, q).val);

    }


}