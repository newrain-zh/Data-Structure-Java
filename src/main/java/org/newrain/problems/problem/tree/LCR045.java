package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * LCR 045. 找树左下角的值
 */
public class LCR045 {

    int depth = 0;
    int ans   = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    /**
     * dfs 遍历
     *
     * @param treeNode
     * @param deep
     * @return
     */
    public int dfs(TreeNode treeNode, int deep) {
        deep++;
        if (treeNode == null) {
            return deep;
        }
        dfs(treeNode.left, deep);
        dfs(treeNode.right, deep);
        if (treeNode.left == null && treeNode.right == null) { // 到了叶子节点
            if (deep > depth) {
                depth = deep;
                ans   = treeNode.val;
            }
        }
        return deep;
    }




    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1});
        System.out.println(new LCR045().findBottomLeftValue(treeNode));
    }
}