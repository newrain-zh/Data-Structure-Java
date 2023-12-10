package org.newrain.code.problem.array;


/**
 * leetcode.643 子数组的最大平均数
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 */
public class FindMaxAverage {

    /**
     * 滑动窗口解法
     * 可以理解为一个大小为k的窗口 向右进行滑动
     * 滑动的过程理解为减去左边的值，加上右边的值
     * 然后和滑动窗口内的所有值的和进行比较 获取到最大值
     * <p>
     * 此题目 使用两层for循环的暴力枚举解法会存在超时行为，
     * 部分解题思路中 看到有用for、while 是比滑动解法更优的解法
     * TODO for、while 暴力枚举解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        //初始化滑动窗口
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if (nums.length == k) {//窗口大小等于k 说明没有滑动的空间 直接取值
            return sum / k;
        }
        double maxSum = sum;
        // 滑动窗口
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];//减去左边的值，加上右边的值
            maxSum = Math.max(maxSum, sum);//获取最大值
        }
        // 返回最大平均数
        return maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}