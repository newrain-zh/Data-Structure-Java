package org.newrain.problems.problem.recursive;


import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }


    public static void dfs(TreeNode node, List<Integer> path, List<String> result) {
        path.add(node.val); // 将当前节点加入路径
        // 如果是叶子节点，生成路径字符串
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    sb.append("->");
                }
                sb.append(path.get(i));
            }
            result.add(sb.toString());
        } else {
            // 递归处理子节点
            if (node.left != null) {
                dfs(node.left, path, result);
            }
            if (node.right != null) {
                dfs(node.right, path, result);
            }
        }
        path.remove(path.size() - 1); // 回溯，移除当前节点
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, null, 5});
        TreeNodeUtils.printTree(root);
        LeetCode257 leetCode257 = new LeetCode257();
        System.out.println(leetCode257.binaryTreePaths(root));

        /*TreeNode root = TreeNodeUtils.buildTree(new Integer[]{1, 2});
        TreeNodeUtils.printTree(root);
        LeetCode257 leetCode257 = new LeetCode257();
        System.out.println(leetCode257.binaryTreePaths(root));*/

  /*      TreeNode root = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 5, 6});
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs1(root, path, res);
        System.out.println(res);
        TreeNodeUtils.printTree(root);*/

    }

}