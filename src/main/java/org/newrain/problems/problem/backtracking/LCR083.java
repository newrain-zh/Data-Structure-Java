package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 083. 全排列
 */
public class LCR083 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, boolean[] used, int left, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true; // 选取当前元素
                path.add(nums[i]);
                backtrack(nums, used, i + 1, path);
                // 回溯状态
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new LCR083().permute(new int[]{1, 2, 3});
        permute.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }


}