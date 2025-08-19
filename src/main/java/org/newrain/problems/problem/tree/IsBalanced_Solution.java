package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

public class IsBalanced_Solution {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    public static boolean isBalanced_Solution(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        int diff = deep(pRoot.left) - deep(pRoot.right);
        if (Math.abs(diff) <= 1) {
            return isBalanced_Solution(pRoot.left) && isBalanced_Solution(pRoot.right);
        }
        return false;
    }

    public static int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced_Solution(TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7})));
    }
}