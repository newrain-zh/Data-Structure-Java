package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LCR 044. 在每个树行中找最大值
 */
public class LCR044 {


    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size     = deque.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll == null) {
                    continue;
                }
                maxValue = Math.max(poll.val, maxValue);
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            ans.add(maxValue);
        }
        return ans;
    }




    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues1(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode n, int depth) {
        if (n == null) return;
        if (res.size() == depth) {
            res.add(n.val);
        }
        if (res.get(depth) < n.val) {
            res.set(depth, n.val);
        }
        dfs(n.left, depth + 1);
        dfs(n.right, depth + 1);
    }
}