package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2583. 二叉树中的第 K 大层和
 * // TODO 最
 */
public class LeetCode2583 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        dfs(root, 0, list);
        if (list.isEmpty() || k > list.size()) {
            return -1L;
        }
        Collections.sort(list);

        return list.get(list.size() - k);
    }


    public void dfs(TreeNode root, int depth, List<Long> list) {

        if (root == null) {
            return;
        }
        if (depth == list.size()) {
            list.add((long) root.val);
        } else {
            list.set(depth, root.val + list.get(depth));
        }
        depth++;
        dfs(root.left, depth, list);
        dfs(root.right, depth, list);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 8, 9, 2, 1, 3, 7, 4, 6});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 8, 9, 2, 1, 3, 7});
        System.out.println(new LeetCode2583().kthLargestLevelSum(treeNode, 4));
    }
}