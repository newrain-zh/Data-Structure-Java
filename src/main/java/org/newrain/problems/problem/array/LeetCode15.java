package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode15. 三数之和
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    System.out.println("i=" + i + ",l=" + l + ",r=" + r);
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        System.out.println(new LeetCode15().threeSum(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));


    }
}