package org.newrain.problems.problem.tree;


import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.*;

/**
 * 二叉树的锯齿形层遍历
 */
public class LeetCode103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> ans   = new ArrayList<>();
        Deque<TreeNode>     deque = new ArrayDeque<>();
        deque.offer(root);
        boolean lr = false; // 控制方向
        while (!deque.isEmpty()) {
            int           size = deque.size();
            List<Integer> curr = new ArrayList<>();
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
            if (size == 1) {
                ans.add(curr);
                lr = !lr;
                continue;
            }
            List<Integer> list = new ArrayList<>(curr.size());
            if (!lr) { // false 从前向后遍历
                list.addAll(curr);
            } else {  // 倒序
                for (int i = curr.size() - 1; i >= 0; i--) {
                    list.add(curr.get(i));
                }
            }
            lr = !lr;
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = zigzagLevelOrder(TreeNodeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}));
        lists.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
    }
}