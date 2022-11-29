package org.newrain.code.offer;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    static List<List<Integer>> res;

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        dfs(root, target, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(8);
        root.left = left1;
        root.right = right1;

        TreeNode leftRoot = new TreeNode(11);
        left1.left = leftRoot;
        TreeNode leftRoot1 = new TreeNode(2);
        TreeNode leftRoot2 = new TreeNode(7);
        leftRoot.left = leftRoot1;
        leftRoot.right = leftRoot2;

        pathSum(root, 22);

    }

    static void dfs(TreeNode root, int target, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target = target - root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(root.left, target, new ArrayList<>(list));
        dfs(root.right, target, new ArrayList<>(list));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
