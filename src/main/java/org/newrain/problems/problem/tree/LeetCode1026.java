package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode.1026 节点与其祖先之间的最大差值
 */
public class LeetCode1026 {


    /**
     * 解法 1：路径寻找最大值和最小值
     * 这里通过保存路径，到叶子节点时来判断 该路径时的最大值和最小值
     *
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, new ArrayList<>());
        return ans;
    }

    int ans = -1;

    public void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        dfs(root.left, path);
        dfs(root.right, path);
        if (root.left == null && root.right == null) { // 到了根节点 ，同一路径结束
            System.out.println(path);
            int max = path.get(0), min = path.get(0);
            for (Integer num : path) {
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
            }
            int diff = Math.abs(max - min);
            ans = Math.max(diff, ans);
        }
        if (!path.isEmpty()) {
            path.remove(path.size() - 1);
        }
    }


    public int[] findMinAndMax(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] p  = findMinAndMax(node.left);
        int[] q  = findMinAndMax(node.right);
        int   mn = Math.min(node.val, Math.min(p[0], q[0]));
        int   mx = Math.max(node.val, Math.max(p[1], q[1]));
        ans = Math.max(ans, Math.max(node.val - mn, mx - node.val));
        return new int[]{mx, mn};
    }

    public int[] findMinAndMax1(TreeNode node) {

        return new int[2];

    }

    private int maxDiff = 0;

    public void dfs(TreeNode node, int currentMax, int currentMin) {
        if (node == null) {
            return;
        }
        int diffWithMax = Math.abs(currentMax - node.val);
        int diffWithMin = Math.abs(currentMin - node.val);
        maxDiff = Math.max(maxDiff, Math.max(diffWithMax, diffWithMin));
        int newMax = Math.max(currentMax, node.val);
        int newMin = Math.min(currentMax, node.val);
        dfs(node.left, newMax, newMin);
        dfs(node.right, newMax, newMin);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{0, null, 1});
        TreeNodeUtils.printTree(treeNode);
        System.out.println(new LeetCode1026().maxAncestorDiff(treeNode));
    }
}