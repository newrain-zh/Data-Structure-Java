package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * @author NewRain
 * <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/">...</a>
 */
public class LeetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add((double) (root.val));
        if (root.left == null && root.right == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int level = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode poll = deque.poll();
                if (poll == null) {
                    continue;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                    list.add(poll.left.val);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                    list.add(poll.right.val);
                }
            }
            if (!list.isEmpty()) {
                double sum = 0;
                for (Integer i : list) {
                    sum += i;
                }
                if (sum == 0) {
                    res.add((double) 0);
                } else {
                    res.add(sum / list.size());
                }
            }
        }
        return res;
    }

    /**
     * averageOfLevels的优化版本
     * 区别在于是否使用了 list
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels1(TreeNode root) {

        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add((double) (root.val));
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode poll = deque.poll();
                sum += poll.val;
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            res.add(sum / len);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode637().averageOfLevels(TreeNodeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}