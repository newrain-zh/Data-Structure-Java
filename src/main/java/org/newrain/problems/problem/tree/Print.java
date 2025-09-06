package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Print {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>(0);
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>() {{
            add(pRoot.val);
        }});
        boolean            isRight = true;
        ArrayList<Integer> currLevel;
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            currLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                    currLevel.add(poll.left.val);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                    currLevel.add(poll.right.val);
                }
            }
            if (!currLevel.isEmpty()) {
                if (isRight) {
                    ArrayList<Integer> cur = new ArrayList<>(currLevel.size());
                    for (int i = currLevel.size() - 1; i >= 0; i--) {
                        cur.add(currLevel.get(i));
                    }
                    res.add(cur);
                    isRight = false;
                } else {
                    res.add(currLevel);
                    isRight = true;
                }
            }
        }
        return res;

    }
}