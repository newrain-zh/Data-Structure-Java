package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode.2415 反转二叉树的奇数层
 */
public class LeetCode2415 {


    /**
     * 层序遍历 保存奇数层的节点，然后用双指针指向数组的开始和结束节点进行交换
     *
     * @param root
     * @return
     */
    public static TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = -1;
        while (!deque.isEmpty()) {
            int            size      = deque.size();
            List<TreeNode> levelList = new ArrayList<>();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (level % 2 == 1) {
                    levelList.add(poll);
                }
                if (poll == null) {
                    continue;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            if (levelList.isEmpty()) {
                continue;
            }
            // 开始反转逻辑
            int left = 0, right = levelList.size() - 1;
            while (left < right) {
                TreeNode leftNode  = levelList.get(left);
                TreeNode rightNode = levelList.get(right);
                if (leftNode.val == rightNode.val) {
                    left++;
                    right--;
                    continue;
                }
                int temp = rightNode.val;
                rightNode.val = leftNode.val;
                leftNode.val  = temp;
                left++;
                right--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2});
        TreeNodeUtils.printTree(treeNode);
        TreeNode reversed = reverseOddLevels(treeNode);
        TreeNodeUtils.printTree(reversed);
    }
}