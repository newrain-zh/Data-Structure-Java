package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 */
public class LintCode17 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        if (nums.length == 0) {
            return ans;
        }
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> path) {
        if (!path.isEmpty()) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LintCode17          lintCode17 = new LintCode17();
        List<List<Integer>> subsets    = lintCode17.subsets(new int[]{4, 1, 0});
        subsets.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }
}