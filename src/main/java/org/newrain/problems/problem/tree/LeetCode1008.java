package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode.1008 前序遍历构建一个二叉搜索树
 */
public class LeetCode1008 {

    private int   index = 0;
    private int[] preorder;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        return build(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int lower, int upper) {
        if (index >= preorder.length) {
            return null;
        }
        int val = preorder[index];
        if (val < lower || val > upper) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        index++;
        root.left  = build(lower, val);
        root.right = build(val, upper);
        return root;
    }


    public static void main(String[] args) {
        TreeNode treeNode  = new LeetCode1008().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        TreeNode treeNode1 = new LeetCode1008().bstFromPreorder(new int[]{1, 3, 2});
        TreeNodeUtils.printTree(treeNode);
//        TreeNodeUtils.printTree(treeNode1);
        System.out.println("---=---------");
        TreeNodeUtils.printTree(TreeNodeUtils.buildTree(new Integer[]{8, 5, 10, 1, 7, null, 12}));
    }

}