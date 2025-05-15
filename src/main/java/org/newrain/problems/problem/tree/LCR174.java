package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  LCR.174 寻找二叉搜索树中的目标节点
 */
public class LCR174 {


    public int findTargetNode(TreeNode root, int cnt) {
        List<Integer> path = new ArrayList<>();
        inOrder(root, path);
        return path.get(path.size() - cnt);
    }


    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /*
       解法 2
     */

    private int res;
    private int cnt;
    public int findTargetNode1(TreeNode root, int cnt) {
        this.cnt = cnt;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.right);

        if (cnt == 0) return;
        if (--cnt == 0) res = root.val;

        helper(root.left);
    }

    public static void main(String[] args) {
        System.out.println(new LCR174().findTargetNode(TreeNodeUtils.buildTree(new Integer[]{7, 3, 9, 1, 5}), 2));
    }

}