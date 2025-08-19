package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

public class HasPathSum {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int t = sum - root.val;
        if (root.left == null && root.right == null) {
            return t == 0;
        }
        return hasPathSum(root.left, t) || hasPathSum(root.right, t);
    }

    static boolean res = false;

    public static void dfs(TreeNode root, int target) {
        if (root == null) return;
        if (root.val == target) {
            res = true;
            return;
        }
        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 4, 8, 1, 11, null, 9, null, null, 2, 7});
//        System.out.println(hasPathSum(treeNode, 22));

//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2});
//        System.out.println(hasPathSum(treeNode, 3));

        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2});
        System.out.println(hasPathSum(treeNode, 1));
    }


}