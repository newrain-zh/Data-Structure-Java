package org.newrain.problems.problem.backtracking;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode.129 求根节点到叶节点数字之和
 */
public class LeetCode129 {

    public static int sumNumbers(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, new ArrayList<>());
        System.out.println(Arrays.toString(ans.toArray()));
        int ret = 0;
        for (Integer an : ans) {
            ret += an;
        }
        return ret;
    }

    public static void dfs(TreeNode root, List<Integer> ans, List<String> path) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) { // 这里是到了叶子节点 意味着也只有叶子节点才会执行这段代码
            path.add(root.val + "");
            StringBuilder sumStr = new StringBuilder();
            for (String string : path) {
                sumStr.append(string);
            }
            ans.add(Integer.parseInt(String.valueOf(sumStr)));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val + "");
        dfs(root.left, ans, path);
        dfs(root.right, ans, path);
        path.remove(path.size() - 1); // 回溯
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{4, 9, 0, 5, 1});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3});
        System.out.println(sumNumbers(treeNode));
    }
}