package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode.671 二叉树中第二小的节点
 * @link <a href="https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/description/">...</a>
 */
public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> list = new HashSet<>();
        foreach(root, list);
        if (list.size() <= 1) {
            return -1;
        }
        List<Integer> list1 = new ArrayList<>(list);
        int max = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (Integer i : list1) {
            if (i <= max) {
                second = max;
                max = i;
            } else {
                if (i <= second) {
                    second = i;
                }
            }
        }
        return second;

    }


    public void foreach(TreeNode node, Set<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        foreach(node.left, list);
        foreach(node.right, list);
    }
}