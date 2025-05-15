package org.newrain.problems.problem.tree;
import org.newrain.problems.problem.common.TreeNode;
/**
 * leetcode
 * LCR 176. 判断是否为平衡二叉树
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * <p>
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class IsBalanced {


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(deepDiff(root.left) - deepDiff(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }


    public int deepDiff(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(deepDiff(treeNode.left), deepDiff(treeNode.right)) + 1;
    }

}