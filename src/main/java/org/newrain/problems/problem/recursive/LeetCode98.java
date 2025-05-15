package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode98 验证二叉搜索树
 */
public class LeetCode98 {


    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public boolean dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) { // 判断当前节点值是否在合理范围内
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }


    /**
     * 通过中序遍历，如果是二叉搜索树的话必定是数组的元素都是升序
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs1(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void dfs1(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        dfs1(treeNode.left, list);
        list.add(treeNode.val);
        dfs1(treeNode.right, list);
    }

    public static void testCase1() {
        LeetCode98 leetCode98 = new LeetCode98();
        TreeNode treeNode1 = TreeNodeUtils.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6}); // false
        TreeNode treeNode2 = TreeNodeUtils.buildTree(new Integer[]{2, 1, 3}); // true
        TreeNode treeNode3 = TreeNodeUtils.buildTree(new Integer[]{2, 2, 2}); // false
        TreeNode treeNode4 = TreeNodeUtils.buildTree(new Integer[]{5, 4, 6, null, null, 3, 7});
        System.out.println(leetCode98.isValidBST1(treeNode1));
        System.out.println(leetCode98.isValidBST1(treeNode2));
        System.out.println(leetCode98.isValidBST1(treeNode3));
        System.out.println(leetCode98.isValidBST1(treeNode4));
    }

    public static void testCase() {
        LeetCode98 leetCode98 = new LeetCode98();
        TreeNode treeNode1 = TreeNodeUtils.buildTree(new Integer[]{5, 1, 4, null, null, 3, 6}); // false
        TreeNode treeNode2 = TreeNodeUtils.buildTree(new Integer[]{2, 1, 3}); // true
        TreeNode treeNode3 = TreeNodeUtils.buildTree(new Integer[]{2, 2, 2}); // false
        TreeNode treeNode4 = TreeNodeUtils.buildTree(new Integer[]{5, 4, 6, null, null, 3, 7});
        System.out.println(leetCode98.isValidBST(treeNode1));
        System.out.println(leetCode98.isValidBST(treeNode2));
        System.out.println(leetCode98.isValidBST(treeNode3));
        System.out.println(leetCode98.isValidBST(treeNode4));
    }


    public static void main(String[] args) {
        testCase();
//        testCase1();
    }
}