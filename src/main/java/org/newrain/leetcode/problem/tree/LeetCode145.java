package org.newrain.leetcode.problem.tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        prevOrder(root, list);
        return list;
    }

    public void prevOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
          return;
        }
        prevOrder(root.left, list);
        prevOrder(root.right, list);
        list.add(root.val);
    }
}
