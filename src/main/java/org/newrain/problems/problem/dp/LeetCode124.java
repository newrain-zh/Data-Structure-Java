package org.newrain.problems.problem.dp;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大路径和
 */
public class LeetCode124 {

    private List<Integer> list = new ArrayList<>();

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    int ans = Integer.MIN_VALUE;

    /*
        自己 + 左 + 右
     */
    public int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left  = Math.max(0, dfs(treeNode.left));
        int right = Math.max(0, dfs(treeNode.right));
        int sum   = treeNode.val + left + right;
        ans = Math.max(sum, ans);

        return Math.max(left + treeNode.val, right + treeNode.val);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{-10, 9, 20, null, null, 15, 7});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{2, -1});
        System.out.println(new LeetCode124().maxPathSum(treeNode));
    }
}