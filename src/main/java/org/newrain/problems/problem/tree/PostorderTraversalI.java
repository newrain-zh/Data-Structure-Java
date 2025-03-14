package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * lintcode.1783 二叉树的后序遍历
 * @author NewRain
 * @description 二叉树的后序遍历
 * @link <a href="https://www.lintcode.com/problem/1783">lintcode</a>
 */
public class PostorderTraversalI {

    /**
     * @param root: A Tree
     * @return Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}