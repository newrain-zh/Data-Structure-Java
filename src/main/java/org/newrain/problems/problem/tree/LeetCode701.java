package org.newrain.problems.problem.tree;


import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode.701 二叉搜索树中的插入操作
 */
public class LeetCode701 {


    public TreeNode insertIntoBST(TreeNode root, int val) {
        return dfs(root, val);

    }


    public TreeNode dfs(TreeNode root, int insertVal) {
        if (root == null) {
            return new TreeNode(insertVal);
        }
        if (insertVal < root.val) {
            root.left = dfs(root.left, insertVal);
        } else {
            root.right = dfs(root.right, insertVal);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode  = TreeNodeUtils.buildTree(new Integer[]{4, 2, 7, 1, 3});
        TreeNode treeNode1 = new LeetCode701().insertIntoBST(treeNode, 5);
        System.out.println(treeNode1.val);
    }


    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode pos = root;
            while (pos != null) {
                if (val < pos.val) {
                    if (pos.left == null) {
                        pos.left = new TreeNode(val);
                        break;
                    } else {
                        pos = pos.left;
                    }
                } else {
                    if (pos.right == null) {
                        pos.right = new TreeNode(val);
                        break;
                    } else {
                        pos = pos.right;
                    }
                }
            }
            return root;
        }
    }


}