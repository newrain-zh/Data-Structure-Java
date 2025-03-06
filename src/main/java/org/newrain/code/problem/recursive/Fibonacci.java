package org.newrain.code.problem.recursive;

public class Fibonacci {


    /**
     * Fibonacci 数列
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
     *
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public static int fibonacci(int n) { //4
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // 第 4 位是 2
        // n-1 = 3   n-2 = 2
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Fibonacci 数列
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
     *
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public static int fibonacci1(int n) {
        int first = 0;
        int second = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }


    public static void main(String[] args) {
//        System.out.println(fibonacci(4));
        System.out.println(fibonacci1(10));
    }
}