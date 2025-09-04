package org.newrain.problems.newcoder;


import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class BM33 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public static TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) return pRoot;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(pRoot);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.push(poll.left);
                }
                if (poll.right != null) {
                    deque.push(poll.right);
                }
                TreeNode left  = poll.left;
                TreeNode right = poll.right;
                TreeNode temp  = left;
                poll.left  = right;
                poll.right = temp;

            }
        }
        return pRoot;
    }

    public static void main(String[] args) {
        TreeNodeUtils.printTree(Mirror(TreeNodeUtils.buildTree(new Integer[]{8, 6, 10, 5, 7, 9, 11})));

    }
}