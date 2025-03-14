package org.newrain.problems.problem.base;

import java.util.Arrays;


/**
 * leetcode
 * LCR 003. 比特位计数
 *
 *
 */
public class CountBits {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = bitmapCount(i);
        }
        return ans;
    }

    /**
     * 统计一个二进制为1的个数
     * @param x
     * @return
     */
    public static int bitmapCount(int x) {
        int cnt = 0;
        while (x > 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }


}