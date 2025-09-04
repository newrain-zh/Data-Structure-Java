package org.newrain.problems.offer;

import org.newrain.problems.problem.common.TreeNode;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return false;
    }

    private boolean eq(TreeNode a, TreeNode b) {
        if (a.val == b.val) {
            return true;
        }

        return false;
    }



}