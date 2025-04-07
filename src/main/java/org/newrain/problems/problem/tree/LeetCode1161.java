package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode.1161 最大层内元素和
 */
public class LeetCode1161 {

    int max = Integer.MIN_VALUE;
    int ans = -1;

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;
        while (!deque.isEmpty()) {
            level++;
            int size     = deque.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                levelSum += pop.val;
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }
            }
            if (levelSum > max) {
                max = levelSum;
                ans = level;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 7, 0, 7, -8, null, null});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{-100, -200, -300, -20, -5, -10, null});
        System.out.println(new LeetCode1161().maxLevelSum(treeNode));
    }
}