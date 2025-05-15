package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode.113 路径总和 II
 */
public class LeetCode113 {

    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);
        return ans;
    }


    public void dfs(TreeNode treeNode, List<Integer> path, int targetSum) {
        if (treeNode == null) {
            return;
        }
        targetSum -= treeNode.val;
        path.add(treeNode.val);
        if (treeNode.left == null && treeNode.right == null) { // 当前为根节点开始判断
            if (targetSum == 0) {
                ans.add(new ArrayList<>(path));
            }
        }
        dfs(treeNode.left, path, targetSum);
        dfs(treeNode.right, path, targetSum);
        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode113 leetCode113 = new LeetCode113();
//        TreeNode            treeNode    = TreeNodeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
//        List<List<Integer>> list     = leetCode113.pathSum(treeNode, 22);
//        TreeNode            treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3});
//        List<List<Integer>> list     = leetCode113.pathSum(treeNode, 5);
        TreeNode            treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2});
        List<List<Integer>> list     = leetCode113.pathSum(treeNode, 1);
        for (List<Integer> integers : list) {
            System.out.println(Arrays.toString(integers.toArray()));
        }

    }
}