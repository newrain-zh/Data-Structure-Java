package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.NTreeNode;
import org.newrain.code.problem.utils.NTreeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal">dz</a>
 */
public class LeetCode590 {

    public static List<Integer> postorder(NTreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public static void dfs(NTreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        //后序遍历的顺序为左-> 右 -> 根
        List<NTreeNode> children = root.children;
        for (NTreeNode child : children) {
            dfs(child, list);
        }
        list.add(root.val);
    }

    public static void main(String[] args) {
        NTreeNode NTreeNode = NTreeUtils.buildTree(Arrays.asList(1, null, 3, 2, 4, null, 5, 6));
        System.out.println(postorder(NTreeNode));
    }
}