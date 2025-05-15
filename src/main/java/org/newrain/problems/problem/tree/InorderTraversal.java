package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 树的中序遍历
 */
public class InorderTraversal {


    List<Integer> list = new ArrayList<>();

    /**
     * @param root: A Tree
     * @return Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inOrder(root);
        return list;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}