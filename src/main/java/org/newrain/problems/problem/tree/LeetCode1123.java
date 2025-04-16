package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

/**
 * 最深叶节点的最近公共祖先
 */
public class LeetCode1123 {


    int maxDeep = 0;
    private TreeNode ans;


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode treeNode, int deep) {
        if (treeNode == null) {
            return deep - 1;
        }
        int currDeep  = deep + 1;
        if (deep > maxDeep){
            maxDeep = deep;
            ans = treeNode;
        }
        int leftDeep  = dfs(treeNode.left, currDeep);
        int rightDeep = dfs(treeNode.right, currDeep);
        if (leftDeep == maxDeep && rightDeep == maxDeep){
            ans = treeNode;
        }
        return Math.max(leftDeep, rightDeep);
    }

    public static void main(String[] args) {

    }

}