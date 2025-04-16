package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 具有所有最深节点的最小子树
 */
public class LeetCode865 {

    private TreeNode ans;

    private int maxDeep = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return ans == null ? root : ans;
    }



    public int dfs(TreeNode treeNode, int deep) {
        if (treeNode == null) {
            return deep - 1;
        }
        if (deep > maxDeep) {
            ans     = treeNode;
            maxDeep = deep;
        }
        int l = dfs(treeNode.left, deep + 1);
        int r = dfs(treeNode.right, deep + 1);
        if (l == maxDeep && r == maxDeep) {
            ans = treeNode;
        }
        return Math.max(l, r);
    }

    /*
           ❌错误解法
        */
    public void dfs(TreeNode treeNode, int deep, TreeNode parentNode) {
        if (treeNode == null) {
            return;
        }
        int currDeep = deep + 1;

        dfs(treeNode.left, currDeep, treeNode);
        dfs(treeNode.right, currDeep, treeNode);
        if (deep > maxDeep) {
            maxDeep = deep;
            if (parentNode.left != null && parentNode.right != null) {
                ans = parentNode;
                return;
            }
            if (treeNode.left == null && treeNode.right == null) {
                ans = treeNode;
            }
        }
    }
    public static void main(String[] args) {
        LeetCode865 leetCode865 = new LeetCode865();
//        TreeNode    treeNode    = TreeNodeUtils.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}); //[2,7,4]
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1}); // [1]
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{0, 1, 3, null, 2});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{0, 1, 3, 2, null, null, null, 4});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{0, 3, 1, 4, null, 2, null, null, 6, null, 5});
        TreeNode res      = leetCode865.subtreeWithAllDeepest(treeNode);
        TreeNodeUtils.printTree(res);


    }
}