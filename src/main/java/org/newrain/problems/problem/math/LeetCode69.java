package org.newrain.problems.problem.math;

/**
 * LeetCode.69 x的平方根
 */
public class LeetCode69 {

    public static int mySqrt(int x) {

        if (x == 1 || x == 0) {
            return x;
        }

        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSqrt = (long) mid * mid;
            if (midSqrt == x) {
                return mid;
            }
            if (midSqrt < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(4));
    }

}