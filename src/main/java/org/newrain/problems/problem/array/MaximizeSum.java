package org.newrain.problems.problem.array;


/**
 * 题目: leetcode.2656 k个元素的最大和
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
 * 从 nums 中选择一个元素 m 。
 * 将选中的元素 m 从数组中删除。
 * 将新元素 m + 1 添加到数组中。
 * 你的得分增加 m 。
 * 请你返回执行以上操作恰好 k 次后的最大得分。
 */
public class MaximizeSum {

    public static int maximizeSum(int[] nums, int k) {
        int ans = 0, max = 0;
        for (int num : nums) {//先获取最大值，最大值+1 肯定也是最大值
            max = Math.max(num, max);
        }
        ans += max; //第一次是最大值的本身，此后max都执行+1操作
        for (int i = 1; i < k; i++) {
            max++;
            ans += max;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximizeSum(new int[]{1, 2, 3, 4, 5}, 3));
    }

}