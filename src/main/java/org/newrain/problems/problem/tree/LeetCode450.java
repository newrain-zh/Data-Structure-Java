package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode450.删除二叉搜索树中的节点
 */
public class LeetCode450 {


    TreeNode prev;

    /**
     * 二叉搜索树 删除一个节点需要考虑以下三种情况
     * 目标是叶子节点直接删除
     * 目标只有一个节点，直接用该子节点替换该节点
     * 目标有 2 个子节点，用右子树的最小节点或者左子树最大节点替换该节点，然后删除替换的节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = dfs(root.left, key);
        } else if (key > root.val) {
            root.right = dfs(root.right, key);
        } else { // root == key
            // 只有一个子节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right); // 找到右子树最小节点
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    public static TreeNode findMin(TreeNode treeNode) {
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }


    public TreeNode dfs(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        root.left  = dfs(root.left, key);
        root.right = dfs(root.right, key);
        if (root.val == key) {
            if (root.right != null) {
                root.right.left = root.right;
                return root.right;
            }
            if (root.left != null) {
                root.left.right = root.left;
                return root.left;
            }

        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        new LeetCode450().deleteNode(treeNode, 3);
        System.out.println();
    }

}