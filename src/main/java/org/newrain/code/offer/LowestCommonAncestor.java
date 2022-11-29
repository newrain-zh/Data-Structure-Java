package org.newrain.code.offer;

public class LowestCommonAncestor {

    TreeNode treeNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < q.val && root.val < p.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if (root.left.val == p.val && root.right.val == q.val) {
            treeNode = root;
        }
        if (root.right.val == p.val && root.left.val == q.val) {
            treeNode = root;
        }

        dfs(root.left, p, q);
        dfs(root.right, p, q);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
