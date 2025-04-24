package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/*
 检查是否子树
 */
public class LeetCode0410 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) { // 空树是任何树的子树
            return true;
        }
        return dfs(t1, t2);

    }

    private boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null) { // t1 遍历到叶子节点还没找到还未找到符合t2结构相同的子树则返回 false
            // 当 dfs 方法中 t1 == null 时，说明主树 t1 的当前分支已经遍历到底部，
            // 但 t2 尚未遍历完成（因为主方法已排除 t2 为空的情况）。此时显然无法匹配 t2 的结构，直接返回 false。
            // check(t1.left, t2) || check(t1.right, t2); 要在左右子树上寻找 左子树上没找到 返回 false
            // 如果右子树找到 返回 true true||false
            //  未找到与 t2相同的子树的情况 如果t1 遍历到叶子节点 这里返回 true ,就会返回错误结果
            return false;
        }
        if (t1.val == t2.val && check(t1, t2)) { // 找到相同节点 递归检查 t1,t2
            return true;
        }
        return dfs(t1.left, t2) || dfs(t1.right, t2);

    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) { // 两颗树同时遍历结束
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3});
        TreeNode t2 = TreeNodeUtils.buildTree(new Integer[]{2});
        System.out.println(new LeetCode0410().checkSubTree(t1, t2));
    }
}