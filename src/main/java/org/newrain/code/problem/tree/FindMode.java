package org.newrain.code.problem.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode.501 二叉搜索树中的众树
 * @author NewRain
 * @description 二叉搜索树中的众数
 * @link <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/">...</a>
 */
public class FindMode {

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //记录每个数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        //记录众数是什么数
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        //保存众数
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        //转换为数组输出
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode treeNode, Map<Integer, Integer> map) {
        if (treeNode == null) {
            return;
        }
        map.put(treeNode.val, map.getOrDefault(treeNode.val, 0) + 1);
        dfs(treeNode.left, map);
        dfs(treeNode.right, map);
    }


}