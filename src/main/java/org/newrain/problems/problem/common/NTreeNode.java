package org.newrain.problems.problem.common;

import java.util.List;


/**
 * N 叉树节点
 */
public class NTreeNode {

    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {
    }

    public NTreeNode(int _val) {
        val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }

}