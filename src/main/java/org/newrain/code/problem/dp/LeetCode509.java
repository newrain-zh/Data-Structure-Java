package org.newrain.code.problem.dp;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 */
public class LeetCode509 {


    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public static int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0;
        int g = 1;
        int r = 0;
        for (int i = 2; i <= n; ++i) {
            p = i - 1;
            g = i - 2;
            r = p + g;

        }
        return r;
    }

    /**
     * 递归方法实现
     * f(n) = f(n - 1) + f(n - 2)
     * 最高支持 n = 92 ，否则超出 Long.MAX_VALUE
     *
     * @param num
     * @return
     */
    public static int fib3(int num) {
        if (num < 1) {
            return 0;
        }
        if (num < 3) {
            return 1;
        }
        return fib3(num - 1) + fib3(num - 2);
    }


    public static void main(String[] args) {
        System.out.println(fib(9));
        System.out.println(fib1(9));
    }
}
