package org.newrain.problems.problem.base;

/**
 * 题目： leetcode.342 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * @author NewRain
 * @link <a href="https://leetcode.cn/problems/power-of-four">...</a>
 * @description 4的幂
 */
public class IsPowerOfFour {

    /**
     * 递归解法
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);

    }

    public static boolean isPowerOfFour1(int n) {
        //check(is or not) a power of 2.
        if (n < 0 || (n & (n - 1)) == 0) {
            return false;
        }
        System.out.println(n & 0x55555555);
        //check 1 on odd bits
        return (n & 0x55555555) == 1;
    }

    public static boolean isPowerOfFour2(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour2(17));
    }
}