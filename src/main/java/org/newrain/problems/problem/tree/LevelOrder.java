package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrder {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>() {{
            add(root.val);
        }});
        ArrayList<Integer> currLevel;
        while (!deque.isEmpty()) {
            int size = deque.size();
            currLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (pop.left != null) {
                    deque.offer(pop.left);
                    currLevel.add(pop.left.val);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                    currLevel.add(pop.right.val);
                }
            }
            if (!currLevel.isEmpty()) {
                res.add(currLevel);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}