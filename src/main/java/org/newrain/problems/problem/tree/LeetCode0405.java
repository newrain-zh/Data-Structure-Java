package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 *  合法二叉搜索树
 */
public class LeetCode0405 {


    /*
      ❌错误解法
      这里只能判断左右子树是否为二叉搜索树，不能判断当前节点是否为二叉搜索树
      public boolean isValidBST(TreeNode root) {
          if (root == null) {
              return true;
          }
          boolean left  = isValidBST(root.left);
          boolean right = isValidBST(root.right);
          if (root.left != null) {
              if (root.left.val >= root.val) {
                  return false;
              }
          }
          if (root.right != null) {
              if (root.right.val <= root.val) {
                  return false;
              }
          }
          return left && right;
      }*/
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    TreeNode prev;

    public boolean inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        if (!inOrder(treeNode.left)) {
            return false;
        }
        if (prev != null && treeNode.val <= prev.val) {
            return false;
        }
        prev = treeNode;
        return inOrder(treeNode.right);
    }


    public boolean dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        boolean left = dfs(treeNode.left);
        if (!left) {
            return false;
        }
        if (prev != null && treeNode.val <= prev.val) {
            return false;
        }
        prev = treeNode;
        return inOrder(treeNode.right);
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode0405().isValidBST(TreeNodeUtils.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6}))); // false
        System.out.println(new LeetCode0405().isValidBST(TreeNodeUtils.buildTree(new Integer[]{2, 1, 3}))); // true
        System.out.println(new LeetCode0405().isValidBST(TreeNodeUtils.buildTree(new Integer[]{10, 5, 15, null, null, 6, 20}))); // false

    }
}