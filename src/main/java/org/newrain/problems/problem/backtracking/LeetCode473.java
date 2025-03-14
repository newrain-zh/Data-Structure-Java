package org.newrain.problems.problem.backtracking;

import java.util.Arrays;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/matchsticks-to-square/">...</a>
 */
public class LeetCode473 {


    public static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        // 将matchsticks从大到小排序
        // 使用 Stream API 降序排序
        int[] sortedArr = Arrays.stream(matchsticks).boxed()  // 转换为 Integer 流
                .sorted((a, b) -> b - a) // 逆序
                .mapToInt(Integer::intValue) // 转回 int
                .toArray();
        int num = sum / 4;
        return backtrack(sortedArr, new int[4], 0, num);
    }

    /**
     * @param matchsticks 火柴数组
     * @param bucket      桶
     * @param index       索引
     * @param capacity    容量
     * @return
     */
    public static boolean backtrack(int[] matchsticks, int[] bucket, int index, int capacity) {
        if (index >= matchsticks.length) {
            return true;
        }
        for (int j = 0; j < 4; j++) {
            if (bucket[j] + matchsticks[index] > capacity) {
                continue;
            }
            bucket[j] += matchsticks[index];
            if (backtrack(matchsticks, bucket, index + 1, capacity)) {
                return true;
            }
            bucket[j] -= matchsticks[index];
        }
        return false;

    }


    public static void main(String[] args) {
//        System.out.println(makesquare(new int[]{1, 1, 2, 2, 2})); // true
        System.out.println(makesquare(new int[]{3, 3, 3, 3, 4})); // false
//        System.out.println(makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3})); // true
    }
}