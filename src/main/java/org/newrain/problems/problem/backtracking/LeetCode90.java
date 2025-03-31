package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * LeetCode.90 子集 II
 */
public class LeetCode90 {

    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    /**
     * pos 可以理解为二叉树的层级概念
     */
    public void backtrack(int[] nums, int pos, List<Integer> path) {
        for (int i = pos; i < nums.length; i++) {
            // 同层的避免
            if (i > pos && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            System.out.println(Arrays.toString(path.toArray()));
            ans.add(new ArrayList<>(path));
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LeetCode90().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println("=====result======");
        list.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }

}