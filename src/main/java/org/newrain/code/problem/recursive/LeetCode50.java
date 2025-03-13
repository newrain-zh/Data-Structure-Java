package org.newrain.code.problem.recursive;

/**
 * <a href="https://leetcode.cn/problems/powx-n">...</a>
 */
public class LeetCode50 {


    /**
     * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        long power = n;
        if (n < 0) { // 处理负指数
            x = 1 / x;
            power = -power;
        }
        double res = 1.0;
        while (power > 0) {
            if ((power & 1) == 1) {
                res *= x;
            }
            // ✅ 平方 x（模拟二进制的幂次翻倍）
            x *= x; // 平方 x，并将 n 右移一位
            power >>= 1;
        }
        return res;
    }


    public double myPow1(double x, int n) {
        if (n >= 0) {
            return quick(x, n);
        }
        return 1.0 / quick(x, -n);
    }

    public double quick(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quick(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }


    public static void main(String[] args) {
        // 输出一个数的二进制
//        System.out.println(Integer.toBinaryString(11));
//        System.out.println(Integer.parseUnsignedInt("1000", 2));
        System.out.println(myPow(2.0, 0));
    }
}