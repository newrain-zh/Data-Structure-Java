package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LeetCode.993 二叉树的堂兄弟节点
 */
public class LeetCode993 {

    /**
     * 堂兄弟节点要满足以下两个条件
     * 同一深度：两个节点位于二叉树的同一层（即从根节点出发的路径长度相同）。
     * 不同父节点：它们的父节点不是同一个节点。
     * TODO: 再增一个层序遍历
     *
     * @param root
     * @param x
     * @param y
     * @return
     */

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, root, x, y, 0);
        return xDeep == yDeep && (xParent != null && yParent != null) && xParent.val != yParent.val;
    }

    public TreeNode xParent = null;
    public TreeNode yParent = null;
    public int xDeep = -1;
    public int yDeep = -1;


    public void dfs(TreeNode root, TreeNode parent, int x, int y, int deep) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            xParent = parent;
            xDeep = deep;
        }
        if (root.val == y) {
            yParent = parent;
            yDeep = deep;
        }
        dfs(root.left, root, x, y, deep + 1);
        dfs(root.right, root, x, y, deep + 1);
    }

    public static void main(String[] args) {
        LeetCode993 leetCode993 = new LeetCode993();
//        System.out.println(leetCode993.isCousins(TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4}), 4, 3));
        System.out.println(leetCode993.isCousins(TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4));
    }

}