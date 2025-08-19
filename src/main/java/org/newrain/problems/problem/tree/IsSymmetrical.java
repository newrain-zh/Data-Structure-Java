package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

public class IsSymmetrical {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return dfs(pRoot.left, pRoot.right);
    }

    public static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return dfs(p.left, q.right) && dfs(p.right, q.left);
    }

    public static void main(String[] args) {
//        System.out.println(isSymmetrical(TreeNodeUtils.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
//        System.out.println(isSymmetrical(TreeNodeUtils.buildTree(new Integer[]{8, 6, 9, 5, 7, 7, 5})));
        System.out.println(isSymmetrical(TreeNodeUtils.buildTree(new Integer[]{2, 3, 3, 4, 5, null, 4})));
    }
}