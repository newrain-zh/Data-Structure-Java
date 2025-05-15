package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 1022. 从根到叶的二进制数之和
 */
public class LeetCode1022 {

    public static List<List<String>> res = new ArrayList<>();

    // TODO 待优化 用位运算
    public static int sumRootToLeaf(TreeNode root) {
        dfs(root, new ArrayList<>());
        if (res.isEmpty()) {
            return 0;
        }
        int ans = 0;
        for (List<String> re : res) {
            int sum = 0;
            for (String s : re) {
                sum = sum * 2 + Integer.parseInt(s);
            }
            ans += sum;
        }
        return ans;
    }

    public static void dfs(TreeNode treeNode, List<String> path) {
        if (treeNode == null) {
            return;
        }
        path.add(treeNode.val + "");
        if (treeNode.left == null && treeNode.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(treeNode.left, path);
        dfs(treeNode.right, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 0, 1, 0, 1, 0, 1});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 5});
//        dfs(treeNode, new ArrayList<>());
        System.out.println(sumRootToLeaf(treeNode));
    }
}