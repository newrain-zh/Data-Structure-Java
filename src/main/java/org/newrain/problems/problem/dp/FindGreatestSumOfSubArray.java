package org.newrain.problems.problem.dp;

public class FindGreatestSumOfSubArray {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], array[i] + dp[i - 1]);
            res   = Math.max(res, dp[i]);
        }
        return Math.max(res, array[0]);
    }

    public static void main(String[] args) {
        System.out.println(findGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5})); // 18
        System.out.println(findGreatestSumOfSubArray(new int[]{-1, 1, 2, 1}));

    }

}