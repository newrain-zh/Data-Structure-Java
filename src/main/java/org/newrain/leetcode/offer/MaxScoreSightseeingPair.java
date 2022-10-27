package org.newrain.leetcode.offer;

/**
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 示例 2：
 * <p>
 * 输入：values = [1,2]
 * 输出：2
 */
public class MaxScoreSightseeingPair {

    /***
     *  values[i] + values[j] + i - j
     *  可修改为 values[i]+i + values[j]-j
     *  values[i]+i 为mx 则只要要求 mx + values[j]-j 视为当前值 则只要求mx的最大值即可
     *  mx 则为上一个元素的值 然后不停更新其历史数组的最大值
     * @param values
     * @return
     */
    public static int maxScoreSightseeingPair(int[] values) {
        int mx = values[0];
        int res = 0;
        for (int j = 1; j < values.length; j++) {
            res = Math.max(res, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return res;
    }

    /**
     * 暴力破解
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair1(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                max = Math.max(values[i] + values[j] + i - j, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }
}
