package org.newrain.code.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * lintcode.66 树的前序遍历
 * @author NewRain
 * @description 树的前序遍历
 * @link <a href="https://www.lintcode.com/problem/66">lintcode</a>
 */
public class InorderTraversalI {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        prevOrder(root, list);
        return list;
    }

    public void prevOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        prevOrder(root.left, list);
        prevOrder(root.right, list);
    }
}