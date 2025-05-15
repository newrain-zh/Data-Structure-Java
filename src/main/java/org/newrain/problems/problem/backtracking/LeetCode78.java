package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode78 子集
 */
public class LeetCode78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); // [] 第一个元素为空元素
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : res) {
                List<Integer> newSubset = new ArrayList<>(subset); // [] + i = i
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            // 合并新旧子集
            res.addAll(newSubsets);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3})); // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//        System.out.println(subsets(new int[]{0})); // [[],[0]]
//        System.out.println(subsets(new int[]{1, 2})); // [[],[1],[2],[1,2]]
    }
}