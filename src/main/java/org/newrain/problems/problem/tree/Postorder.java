package org.newrain.problems.problem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode.589. N 叉树的后序序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔
 * <p>
 * 提示：
 * 后序遍历的规则为先遍历左子数，再遍历右子数，最后在访问根节点
 */
public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        foreach(root, ans);
        return ans;
    }

    public void foreach(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        List<Node> children = node.children;
        for (Node child : children) {
            foreach(child, list);
        }
        //每次递归时，先递归访问每个孩子节点，然后再访问根节点即可。
        list.add(node.val);//与前序遍历的不同在与此
    }

    public static void main(String[] args) {

    }


}