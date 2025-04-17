package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.*;

/**
 * 出现次数最多的子树元素和
 */
public class LeetCode508 {

    Map<Integer, Integer> countMap = new HashMap<>();
    int                   maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        count(root);
        List<Integer> res = new ArrayList<>();
        for (int sum : countMap.keySet()) {
            if (countMap.get(sum) == maxCount) {
                res.add(sum);
            }
        }

        // 转换为数组返回
        return res.stream().mapToInt(i -> i).toArray();
    }


    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left  = count(root.left);
        int right = count(root.right);
        int sum   = left + right + root.val;
        int count = countMap.getOrDefault(sum, 0) + 1;
        countMap.put(sum, count);
        maxCount = Math.max(count, maxCount);
        return sum;
    }

    public static void main(String[] args) {
//        int[] frequentTreeSum1 = new LeetCode508().findFrequentTreeSum(TreeNodeUtils.buildTree(new Integer[]{5, 2, -3}));
//        int[] frequentTreeSum2 = new LeetCode508().findFrequentTreeSum(TreeNodeUtils.buildTree(new Integer[]{5, 2, -5}));
//        System.out.println(Arrays.toString(frequentTreeSum1));
//        System.out.println(Arrays.toString(frequentTreeSum2));
        int[] frequentTreeSum2 = new LeetCode508().findFrequentTreeSum(TreeNodeUtils.buildTree(new Integer[]{5, 14, null, 1}));
        System.out.println(Arrays.toString(frequentTreeSum2));
    }
}