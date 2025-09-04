package org.newrain.problems.newcoder;

import org.newrain.problems.problem.common.TreeNode;

public class BM37 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param p    int整型
     * @param q    int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // 若当前节点值大于p和q，说明LCA在左子树
        if (root.val > p && root.val > q) {
            return dfs(root.left, p, q).val;
        }
        // 若当前节点值小于p和q，说明LCA在右子树
        else if (root.val < p && root.val < q) {
            return dfs(root.right, p, q).val;
        }
        // 否则当前节点就是LCA
        else {
            return root.val;
        }

    }

    public static TreeNode dfs(TreeNode root, int p, int q) {
        while (root != null) {
            if (root.val > p && root.val > q) {
                root = root.left;
            } else if (root.val < q && root.val < p) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;

    }
}