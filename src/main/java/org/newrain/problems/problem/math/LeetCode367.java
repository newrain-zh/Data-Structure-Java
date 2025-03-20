package org.newrain.problems.problem.math;

/**
 * LeetCode.367 有效的完全平方数
 */
public class LeetCode367 {


    /**
     * [0,num] 之间
     */
    public static boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) { // left <= right 是为了防止漏掉 left == right 仍能循环一次
            int mid = left + (right - left) / 2;
            int curr = mid * mid;
            if (curr == num) {
                return true;
            }
            if (curr > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        System.out.println(isPerfectSquare(8));
//        System.out.println(isPerfectSquare(16));
//        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(1));
    }
}