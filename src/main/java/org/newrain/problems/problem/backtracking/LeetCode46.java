package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/permutations/description/">...</a>
 */
public class LeetCode46 {


    /**
     * nums 规则
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        return null;
    }

    public List<Integer> getPermute(int[] nums, int index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        }
        return list;
    }


}