package org.newrain.problems.problem.tree;
import java.util.List;

/**
 * leetcode.559  N 叉树的最大深度
 */
public class NtreeMaxDepth {


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxChildDepth = 0;
        List<Node> children = root.children;
        for (Node child : children) {
            int childDepth = maxDepth(child);
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }
        return maxChildDepth + 1;

    }
}