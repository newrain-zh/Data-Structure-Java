package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {


    public List<Integer> preorderTraversal(TreeNode root) {
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