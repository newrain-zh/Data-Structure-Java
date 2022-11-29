package org.newrain.code.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[]{};
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            list.add(pop.val);
            if (pop.left != null) {
                deque.add(pop.left);
            }
            if (pop.right != null) {
                deque.add(pop.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
