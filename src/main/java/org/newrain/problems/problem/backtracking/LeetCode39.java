package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode.39 组合总和
 */
public class LeetCode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), 0, ans);
        return null;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, int currentSum, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (currentSum + num > target) {
                break;
            }
            path.add(num);
            backtrack(candidates, target, i, path, currentSum + num, result);
            path.remove(path.size() - 1);

        }
    }
}