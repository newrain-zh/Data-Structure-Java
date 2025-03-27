package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode.897.递增顺序搜索树
 */
public class LeetCode897 {


    TreeNode ans = null;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root, new TreeNode[1]);
        return ans;
    }


    public void dfs(TreeNode treeNode, TreeNode[] prev) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, prev);
        if (prev[0] != null) {
            prev[0].left  = null;
            prev[0].right = treeNode; // 上一个节点指向当前节点
        } else {
            if (ans == null) {
                ans = treeNode;
            }
        }
        prev[0] = treeNode; // 更新前驱节点

        dfs(treeNode.right, prev);
        System.out.println(treeNode.val);
        treeNode.left = null;
    }


    TreeNode tree = new TreeNode(-1);
    TreeNode p    = tree;

    public void dfs1(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs1(treeNode.left);
        p.right = new TreeNode(treeNode.val);
        p       = p.right;
        dfs1(treeNode.right);
    }

    public static void main(String[] args) {
/*
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9});
        TreeNode res      = new LeetCode897().increasingBST(treeNode);
        TreeNodeUtils.printTree(res);
        System.out.println("end");
*/


        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{2, 1, 4, null, null, 3});
        TreeNodeUtils.printTree(treeNode);
        TreeNode res      = new LeetCode897().increasingBST(treeNode);
        System.out.println("end");


        TreeNode treeNode1 = TreeNodeUtils.buildTree(new Integer[]{2, 1, 4, null, null, 3});
//        TreeNodeUtils.printTree(res);
        System.out.println("end");
    }


}