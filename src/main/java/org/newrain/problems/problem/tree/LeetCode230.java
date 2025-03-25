package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * LeetCode 230 二叉树搜索树中第 K 小的元素
 */
public class LeetCode230 {

    public int index = 0; // 索引位置
    public int ans;


    /**
     * 中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        kthSmallest(root.left, k);
        index++;
        if (index == k) {
            ans = root.val;
            return ans;
        }
        kthSmallest(root.right, k);
        return ans;
    }


    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.left, k);
        index++;
        if (index == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }

    /**
     * kthSmallest的改进版本 不用成员变量来记录遍历过程和结果 避免后续调用的污染
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        int[] index = new int[1];
        int[] ans   = new int[1];
        inOrder(root, index, ans, k);
        return ans[0];
    }

    private void inOrder(TreeNode root, int[] index, int[] ans, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, index, ans, k);
        index[0]++;
        if (index[0] == k) {
            ans[0] = root.val;
            return;
        }
/*
        if (index[0] < k) {
            inOrder(root.right, index, ans, k);
        }*/
        inOrder(root.right, index, ans, k);
    }

    /**
     * 中序遍历是 左->根->右
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest3(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode        curr  = root;
        int             count = 0;
        while (curr != null || !deque.isEmpty()) {
            while (curr != null) { // 先向左走
                deque.push(curr);
                curr = curr.left;
            }
            curr = deque.pop();
            count++;
            if (count == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{3, 1, 4, null, 2});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1, 3});
//        TreeNode    treeNode    = TreeNodeUtils.buildTree(new Integer[]{3, 1, 4, null, 2});
        LeetCode230 leetCode230 = new LeetCode230();
//        leetCode230.dfs(treeNode, 1);
        leetCode230.kthSmallest(treeNode, 3);
        System.out.println("result=" + leetCode230.ans);
    }
}