package org.newrain.problems.problem.math;

/**
 * LeetCode.441 排列硬币
 */
public class LeetCode441 {
    public static int arrangeCoins(int n) {
        int step = 1; // 阶梯所需的硬币
        while (n >= step) {
            n -= step; // 减去每行所需的硬币
            step++; // 阶梯向前一步
            System.out.println("n=" + n + ",step=" + step);
        }
        return step - 1;  // 减去多执行的一步
    }

    public static int arrangeCoins1(int n) {
        for (int i = 1; i < n; i++) {
            n -= i;
            if (n < i) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins1(1));
    }

}