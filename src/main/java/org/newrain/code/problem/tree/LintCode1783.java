package org.newrain.code.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 二叉树的后序遍历
 * @link <a href="https://www.lintcode.com/problem/1783">lintcode</a>
 */
public class LintCode1783 {

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