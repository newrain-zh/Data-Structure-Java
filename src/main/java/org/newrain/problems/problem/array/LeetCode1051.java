package org.newrain.problems.problem.array;

import java.util.Arrays;


/**
 * LeetCode.1051 高度检查器
 */
public class LeetCode1051 {


    public static int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length); // 拷贝数组方式 1
//        int[] expected = heights.clone(); //  拷贝数组方式 2
        Arrays.sort(expected);
        int length = heights.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if (expected[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{5, 1, 2, 3, 4}));
    }
}