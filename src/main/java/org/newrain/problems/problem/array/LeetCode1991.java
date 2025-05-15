package org.newrain.problems.problem.array;

/**
 * 找到数组中间位置
 *
 * @author newRain
 * <a href="https://leetcode.cn/problems/find-the-middle-index-in-array/">...</a>
 */
public class LeetCode1991 {

    public static int findMiddleIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int leftSum = 0, rightSum = sum(nums, 1, nums.length - 1);
        int middleIndex;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == rightSum) {
                middleIndex = i;
                return middleIndex;
            } else {
                leftSum += nums[i];
                if (i + 1 < (nums.length)) {
                    rightSum -= nums[i + 1];
                } else {
                    rightSum = 0;
                }
            }
        }
        return -1;
    }

    public static int sum(int[] nums, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static int findMiddleIndex1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (preSum == sum) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }


    public static void main(String[] args) {
//        System.out.println(findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
        System.out.println(findMiddleIndex(new int[]{2, 5}));
        System.out.println(findMiddleIndex(new int[]{1, -1, 4}));
    }


}