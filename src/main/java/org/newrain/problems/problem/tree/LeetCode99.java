package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode.99 恢复二叉搜索树
 * TODO 有更优解 待研究
 */
public class LeetCode99 {

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        if (list.size() == 1) {
            return;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).val;
        }
        Arrays.sort(arr);
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            treeNode.val = arr[i];
        }

    }

    /**
     * 找出需要交换的两个节点值
     *
     * @param nums
     * @return
     */
    public static int[] findTwoSwapped(List<Integer> nums) {
        int n      = nums.size();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i) > nums.get(i + 1)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

    public void dfs(TreeNode treeNode, List<TreeNode> list) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, list);
        list.add(treeNode);
        dfs(treeNode.right, list);
    }

    TreeNode prevNode   = null;
    Integer  replaceVal = null;

    public void dfs1(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs1(treeNode.left);
        if (prevNode == null) {
            prevNode = treeNode;
        } else {
            if (replaceVal != null) {
                if (prevNode.val > treeNode.val) {
                    replaceVal = treeNode.val;
                }
            }
        }
        dfs1(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{3, 1, 4, null, null, 2});
        TreeNodeUtils.printTree(treeNode);
        new LeetCode99().recoverTree(treeNode);
        System.out.println("=======");
        TreeNodeUtils.printTree(treeNode);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        System.out.println(Arrays.toString(findTwoSwapped(list)));


    }
}