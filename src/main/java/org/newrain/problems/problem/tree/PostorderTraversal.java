package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 树的中序遍历
 */
public class PostorderTraversal {


    List<Integer> list = new ArrayList<>();

    /**
     * @param root: A Tree
     * @return Inorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postOrder(root);
        return list;
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
}