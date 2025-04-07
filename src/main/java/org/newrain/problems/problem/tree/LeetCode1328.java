package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode.1382 将二叉搜索树变平衡
 */
public class LeetCode1328 {


    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        return buildTree(list, 0, list.size() - 1);

    }

    public void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    public TreeNode buildTree(List<TreeNode> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int      mid      = (left + right) / 2;
        TreeNode currNode = new TreeNode(list.get(mid).val);
        currNode.left  = buildTree(list, left, mid - 1);
        currNode.right = buildTree(list, mid + 1, right);
        return currNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, null, 2, null, 3, null, 4, null, null});
        TreeNode res      = new LeetCode1328().balanceBST(treeNode);
        TreeNodeUtils.printTree(res);

    }

}