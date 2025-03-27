package org.newrain.problems.problem.tree;


import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.*;

/**
 * LeetCode.662 二叉树最大宽度
 */
public class LeetCode662 {

    /**
     * 给每个节点标记上编号
     * 根据编号来计算每层的宽度
     * 二叉树每层的个数都是乘以 2 的速度增长的
     *
     * @param root
     * @return
     */
    public static int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        Queue<Long> posQueue = new LinkedList<>();
        posQueue.offer(1L);
        int ans = 0;
        while (!deque.isEmpty()) {
            int  depth = deque.size();
            long start = 0, end = 0;
            for (int i = 0; i < depth; i++) {
                TreeNode poll = deque.poll();
                Long     pos  = posQueue.poll();
                if (i == 0) {
                    start = pos;
                }
                if (i == depth - 1) {
                    end = pos;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                    posQueue.offer(2 * pos);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                    posQueue.offer(2 * pos + 1);
                }
            }
            long currentWidth = end - start + 1;
            if (currentWidth > ans) {
                ans = (int) currentWidth;
            }
        }
        return ans;
    }


    private List<Integer> leftmost  = new ArrayList<>();
    private List<Integer> rightmost = new ArrayList<>();

    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        for (int i = 0; i < leftmost.size(); i++) {
            maxWidth = Math.max(maxWidth, rightmost.get(i) - leftmost.get(i) + 1);
        }
    }

    public void dfs(TreeNode treeNode, int depth, int pos) {
        if (treeNode == null) {
            return;
        }
        if (depth == leftmost.size()) {
            leftmost.add(pos);
            rightmost.add(pos);
        } else {
            rightmost.set(depth, pos);
        }
        dfs(treeNode.left, depth, 2 * pos);
        dfs(treeNode.right, depth, 2 * pos + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7});
        widthOfBinaryTree(treeNode);

    }
}