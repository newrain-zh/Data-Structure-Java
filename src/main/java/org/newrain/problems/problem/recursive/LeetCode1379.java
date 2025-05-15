package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;

/**
 * 1379. 找出克隆二叉树中的相同节点
 * <a href="https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/">...</a>
 */
public class LeetCode1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        } else {
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null) {
                return left;
            }
            return getTargetCopy(original.right, cloned.right, target);
        }


    }
}