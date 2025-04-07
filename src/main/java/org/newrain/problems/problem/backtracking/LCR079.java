package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 079. 子集
 */
public class LCR079 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>(0));
        backtracking(nums, 0, new ArrayList<>());
        return ans;
    }

    public void backtracking(int[] nums, int start, List<Integer> path) {
    /*    if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }*/
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            System.out.println("进-> i=" + i + ",start =" + start + ",arr=" + Arrays.toString(path.toArray()));
            backtracking(nums, i + 1, path);
            path.remove(path.size() - 1);
            System.out.println("归<- i=" + i + ",start =" + start + ",arr=" + Arrays.toString(path.toArray()));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new LCR079().subsets(new int[]{1, 2, 3});
        subsets.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
    }


}