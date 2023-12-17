package org.newrain.code.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode.589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔
 *
 */
public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        foreach(root, ans);
        return ans;
    }

    public void foreach(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            foreach(child, list);
        }
    }

    public static void main(String[] args) {

    }


}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}