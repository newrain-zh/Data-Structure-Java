package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode.958 二叉树的完全性检验
 */
public class LeetCode958 {


    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean hasNull = false;
        while (!deque.isEmpty()) {
            TreeNode current = deque.poll();
            if (current == null) {
                hasNull = true;
            } else {
                if (hasNull) {
                    return false;
                }
                // 若当前节点有右子节点但无左子节点，直接返回false
                if (current.left == null && current.right != null) {
                    return false;
                }
                // 将左右子节点按顺序加入队列（包括null）
                deque.offer(current.left);
                deque.offer(current.right);
            }
        }
        return true;
    }



    public boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (root.left == null && root.right != null) {
            return false;
        }
        return l && r;
    }


    private int count = 0;    // 总节点数
    private int maxIndex = 0; // 最大节点编号

    public boolean isCompleteTree1(TreeNode root) {
        dfs(root, 1);
        return maxIndex == count;
    }

    // 递归遍历并更新节点信息
    private void dfs(TreeNode node, int index) {
        if (node == null) return;

        count++;              // 统计实际存在的节点数
        maxIndex = Math.max(maxIndex, index); // 更新最大编号

        // 递归处理左右子节点
        dfs(node.left, 2 * index);
        dfs(node.right, 2 * index + 1);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        System.out.println(new LeetCode958().dfs(treeNode));
    }

}