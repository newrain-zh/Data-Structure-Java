package org.newrain.code.problem.number;

/**
 * @author NewRain
 * @description 丑数
 * @link <a href="https://www.lintcode.com/problem/517/">lintcode</a>
 * @link <a href="https://leetcode.cn/problems/ugly-number/">leetcode</a>
 */
public class IsUgly {


    public boolean isUgly(int n) {
        if (n <= 0) {
            return true;
        }
        int[] arr = new int[]{2, 3, 5};

        for (int a : arr) {
            while (n % a == 0) {
                n /= a;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
    }
}
