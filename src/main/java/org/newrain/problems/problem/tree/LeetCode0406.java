package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 后继者
 */
public class LeetCode0406 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderSuccessor1(root, p);
        return ans;
    }

    TreeNode prev = null;
    TreeNode ans  = null;

    /**
     * 这里使用中序遍历的方式
     *
     * @param root
     * @param p
     */
    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (ans != null) {
            return;
        }
        if (prev != null && prev.val == p.val) {
            ans = root;
//            prev = null;
            return;
        }
        prev = root;
        dfs(root.right, p);
    }

    /**
     * 找一个比 p 值大的最小节点（即，第一个大于 p 的祖先）
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        // [1,2,3,4,5]  p=1 要找的节点就是 2
        // 树是二叉搜索树，左子树都小于根节点，右子树都大于根节点
        // 中序遍历下：要找的节点就是p的下一个节点，也就是说找到所有比 p 大的节点中，值最小的那一个
        TreeNode ans = null;
        while (root != null) {
            if (p.val < root.val) { // 去左子树上找 当前节点可能是后继节点
                ans  = root;
                root = root.left; // 继续往左子树上找
            } else {
                root = root.right; //  p.val >= 当前值
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        TreeNode treeNode = new LeetCode0406().inorderSuccessor(TreeNodeUtils.buildTree(new Integer[]{2, 1, 3}), new TreeNode(1));
        TreeNode treeNode = new LeetCode0406().inorderSuccessor(TreeNodeUtils.buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), new TreeNode(1));
//        TreeNode treeNode = new LeetCode0406().inorderSuccessor(TreeNodeUtils.buildTree(new Integer[]{2, null, 3}), new TreeNode(2));
        System.out.println(treeNode.val);

    }
}