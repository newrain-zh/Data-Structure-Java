package org.newrain.code.problem.array;

public class TwoSumLessThanTarget {

    /*
     * 暴力枚举
     * @param nums: An array of integer
     * @param target: An integer
     * @return: The sum of two numbers smaller than target
     */
    public static int twoSumLessThanTarget1(int[] nums, int target) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] + nums[i] < target) {
                    ans = Math.max(nums[j] + nums[i], ans);
                }
                j++;
            }
        }
        if (ans == Integer.MIN_VALUE) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(twoSumLessThanTarget1(new int[]{2, 7, 11, 15}, 24));//22
        System.out.println(twoSumLessThanTarget1(new int[]{3, 5, 1, 9, 7}, 10));//8
        System.out.println(twoSumLessThanTarget1(new int[]{-2, -3}, -4)); //-5
    }
}