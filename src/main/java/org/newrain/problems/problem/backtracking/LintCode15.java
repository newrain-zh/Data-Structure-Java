package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 */
public class LintCode15 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new LintCode15().permute(new int[]{1, 2, 3});
        permute.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
    }

}