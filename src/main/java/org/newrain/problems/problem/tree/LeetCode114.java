package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 */
public class LeetCode114 {


    public void flattenByEach(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    public void each(TreeNode root, TreeNode treeNode) {
        if (root != null) {
            treeNode.val = root.val;
            if (root.left != null) {
                treeNode.right = root.left;
                each(root.left, treeNode);
            }
            if (root.right != null) {
                treeNode.right = root.right;
                each(root.right, treeNode);
            }
        }
    }


}