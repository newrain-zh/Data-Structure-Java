package org.newrain.code.problem.array;


import java.util.Arrays;

/**
 * leetcode.16 最接近的三数之和
 * @see ThreeSum 同这道题类似
 * @link <a href="https://leetcode.cn/problems/3sum-closest/description/">...</a>
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * <p>
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * <p>
 * 输出：2
 * <p>
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];
                if (sum == target) return target;
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                } else if (sum > target) { //如果当前值比target大 说明需要更小的值 降低总和
                    int r0 = r - 1;
                    while (l < r0 && nums[r] == nums[r0]) { //移动下一个位置，l和l+1的位置的相同，略过避免重复计算
                        --r0;
                    }
                    r = r0;
                } else { //如果当前值比target小 说明需要更大的值 提高总和
                    int l0 = l + 1;
                    while (l0 < r && nums[r] == nums[l0]) { //移动下一个位置
                        l0++;
                    }
                    l = l0;
                }
            }
        }
        return ans;
    }

    /**
     * 最优解 是在上面的方案上优化出来的
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest1(int[] nums, int target) {
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];
                if (sum == target) return target;
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return target - diff;
    }

    public static void main(String[] args) {
//        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 1}, 0));
    }
}