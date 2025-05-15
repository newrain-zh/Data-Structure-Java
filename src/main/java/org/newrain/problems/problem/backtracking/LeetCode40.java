package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode.40 组合总和 II
 */
public class LeetCode40 {

    public int                 target;
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, new ArrayList<>());
        ans.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
        return ans;
    }

    private void backtrack(int[] candidates, int currentSum, int start, List<Integer> path) {
        if (currentSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) { //剪枝
                break;
            }
            // 跳过同一层中的重复元素
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (currentSum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]); // 选择当前元素
            backtrack(candidates, currentSum + candidates[i], i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new LeetCode40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}