package org.newrain.code.problem.math;

/**
 * @author NewRain
 * @description 斐波纳契数列
 * @link <a href="https://www.lintcode.com/problem/366">...lintcode</a>
 */
public class Fibonacci {

    /**
     * 循环
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib[n - 1];
    }

    public int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 2) + fib(n - 1);
    }

    /**
     * 滚动数组
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int first = 1;
        int second = 1;
        int third = 2;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 尾递归
     *
     * @param n
     * @param first  0
     * @param second 1
     * @return
     */
    public int fib5(int n, int first, int second) {
        if (n <= 1) {
            return first;
        } else {
            return fib5(n - 1, second, first + second);
        }
    }

}