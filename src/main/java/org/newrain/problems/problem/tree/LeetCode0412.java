package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 求和路径
 */
public class LeetCode0412 {

    private int target;
    private int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        this.target = sum;
        Map<Integer, Integer> prifixMap = new HashMap<>();
        prifixMap.put(0, 1); // 添加根路径 覆盖根节点
        dfs(root, 0, prifixMap);
        return ans;
    }

    public void dfs(TreeNode root, int currentSum, Map<Integer, Integer> prefixMap) {
        if (root == null) {
            return;
        }
        // int sum = root.val + currentSum; // ❌错误的路径和计算
//        prefixMap.put(sum, prefixMap.getOrDefault(sum, 1));
    /*    if (prefixMap.getOrDefault(target - root.val, 0) > 0) {
            ans++;
        }*/
        currentSum += root.val; // 更新路径和
        ans += prefixMap.getOrDefault(currentSum - target, 0);
        prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        dfs(root.left, currentSum, prefixMap);
        dfs(root.right, currentSum, prefixMap);
        prefixMap.put(currentSum, prefixMap.get(currentSum) - 1);

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0412().pathSum(TreeNodeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
    }

}