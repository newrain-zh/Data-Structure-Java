package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * lintCode.70 · 二叉树的层次遍历 II
 */
public class LintCode70 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>(0);
        }
        List<List<Integer>> res   = new ArrayList<>();
        Deque<TreeNode>     deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int           size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }
                curr.add(pop.val);
            }
            if (!curr.isEmpty()) {
                res.add(curr);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ans.add(res.get(i));
        }
        return ans;

    }
}