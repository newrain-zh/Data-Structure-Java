package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 判断对称二叉树
 */
public class LCR145 {

    /**
     * ❌错误解法
     *
     * @param root
     * @return
     */
   /* public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }


        List<Integer> left = new ArrayList<>();
        dfs(root.left, left);
        List<Integer> right = new ArrayList<>();
        dfs1(root.right, right);
        if (left.size() != right.size()) {
            return false;
        }
        int size = left.size();
        for (int i = 0; i < size; i++) {
            if (!right.get(i).equals(left.get(i))) {
                return false;
            }
        }
        return true;

    }

    public void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            path.add(-1);
            return;
        }
        path.add(root.val);
        dfs(root.left, path);
        dfs(root.right, path);

    }

    public void dfs1(TreeNode root, List<Integer> path) {
        if (root == null) {
            path.add(-1);
            return;
        }
        path.add(root.val);
        dfs(root.right, path);
        dfs(root.left, path);

    }*/
    public boolean checkSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{6, 7, 7, 8, 9, 9, 8});
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{6, 7, 7, 8, null, 8, null});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{2, 3, 3, 4, 5, 5, 4, null, null, 8, 9, 9, 8});
        System.out.println(new LCR145().checkSymmetricTree(treeNode));
    }
}