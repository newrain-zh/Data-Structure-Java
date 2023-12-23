package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * leetcode.15 三数之和
 * @link <a href="https://leetcode.cn/problems/3sum/description/">三数之和</a>
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * <p>
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * <p>
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class ThreeSum {

    /**
     * 首先这里并不是最优解，最优解是在这个基础上进行优化
     *
     * 首先排序，这样左边的肯定是负数，然后使用双指针
     *
     * 这样左右两边的负数和正数加当前数等于0时就表示符合题目中的条件
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//表示数组里没有正数 也就无法找到满足题目中条件的数组
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {//避免重复计算
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Stream.of(nums[i], nums[l], nums[r]).collect(Collectors.toList()));
                    while (l < r && nums[l] == nums[l + 1]) {//避免重复计算
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {//避免重复计算
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) { //需要更大的数来做抵消
                    l++;
                } else {//大于0 需要一个更小的数来降低总和
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        //-1,0,1,2,-1,-4

    }
}