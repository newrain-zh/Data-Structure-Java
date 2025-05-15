package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * LeetCode.95 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class LeetCode95 {


    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        // 从 1 到 n 依次作为根节点
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = buildTree(start, i - 1);
            List<TreeNode> rightTrees = buildTree(i + 1, end);
            // 组合所有的可能
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        new LeetCode95().generateTrees(3);
    }
}