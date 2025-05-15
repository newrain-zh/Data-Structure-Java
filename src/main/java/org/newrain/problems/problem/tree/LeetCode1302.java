package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 层数最深叶子节点的和
 */
public class LeetCode1302 {

    int maxDeep = 0;
    int ans     = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
        if (deep > maxDeep) {
            maxDeep = deep;
            ans     = root.val;
        } else if (deep == maxDeep) {
            ans += root.val;
        }
    }

    public static void main(String[] args) {
        LeetCode1302 leetCode1302 = new LeetCode1302();
//        TreeNode     treeNode     = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8}); // 15
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5}); //19
        System.out.println(leetCode1302.deepestLeavesSum(treeNode));

    }
    }