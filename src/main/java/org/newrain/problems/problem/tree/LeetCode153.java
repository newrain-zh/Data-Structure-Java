package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR153.二叉树中和为目标值的路径
 */
public class LeetCode153 {

    private int target; // 目标值
    private int prefixSum;  // 路径前缀和
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathTarget(TreeNode root, int target) {
        this.target = target;
        dfs(root, new ArrayList<>());
        return ans;
    }


    public void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        prefixSum += root.val;
        path.add(root.val);
        dfs(root.left, path);
        dfs(root.right, path);
        if (root.left == null && root.right == null) {
            if (prefixSum == target) {
                ans.add(new ArrayList<>(path));
            }
        }
        prefixSum -= root.val;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        LeetCode153         leetCode153 = new LeetCode153();
        TreeNode            treeNode    = TreeNodeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> list        = leetCode153.pathTarget(treeNode, 22);
        list.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }
}