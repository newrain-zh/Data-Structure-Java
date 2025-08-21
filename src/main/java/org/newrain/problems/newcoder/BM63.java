package org.newrain.problems.newcoder;

public class BM63 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param number int整型
     * @return int整型
     */
    public static int jumpFloor(int number) {
        if (number == 1) return 1;
        if (number == 2) return 2;
        int[] dp = new int[number];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[number - 1];
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(7));
    }
}