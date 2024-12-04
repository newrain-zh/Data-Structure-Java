package org.newrain.code.offer;

import java.util.*;

public class Offer32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        boolean odd = true;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //队列动态长度变化 这里要用个变量存储当前的size 否则的话就要用倒序的方式遍历
            int size = queue.size();
            // 获取当前队列的节点个数，代表这一层有多少个节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            if (!odd) {
                Collections.reverse(temp);
            }
            res.add(temp);
            odd = !odd;
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> arr = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                arr.add(pop.val);
                if (pop.left != null) {
                    deque.add(pop.left);
                }
                if (pop.right != null) {
                    deque.add(pop.right);
                }
            }
            if (!arr.isEmpty()) {
                list.add(arr);
            }
        }
        return list;
    }

    public static void main(String[] args) {
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