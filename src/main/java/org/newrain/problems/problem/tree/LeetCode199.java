package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.*;

/**
 * LeetCode.199 二叉树的右视图
 */
public class LeetCode199 {


    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size  = deque.size();
            int index = size - 1;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll == null) {
                    continue;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                if (i == index) {
                    ans.add(poll.val);
                }
            }

        }
        System.out.println(Arrays.toString(ans.toArray()));
        return ans;
    }

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView1(TreeNode root) {

        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, null, null, null, 5});
        rightSideView(treeNode);
    }
}