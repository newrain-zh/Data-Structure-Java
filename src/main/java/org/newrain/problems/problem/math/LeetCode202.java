package org.newrain.problems.problem.math;

/**
 * LeetCode 202 快乐树
 */
public class LeetCode202 {

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (fast == 1) {
                return true;
            }

        } while (slow != fast);
        return false;
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(566 % 10); // 取各个位
        System.out.println(566 / 10); // 消除个位
        System.out.println(isHappy(19));

    }
}