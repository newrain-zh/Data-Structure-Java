package org.newrain.problems.problem.search;

/**
 * LeetCode.374 猜数字大小
 */
public class LeetCode374 {


    public int guessNumber(int n) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) == -1) { // 猜的数字比我选的数字大 也就是 mid > guessNum
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int guess(int num) {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode374().guess(10));
        System.out.println(new LeetCode374().guess(1));
    }
}