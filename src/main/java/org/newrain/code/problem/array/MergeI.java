package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题目：leetcode.56 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * @author newrain
 */
public class MergeI {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> mergeList = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (mergeList.isEmpty() || mergeList.get(mergeList.size() - 1)[1] < L) {
                mergeList.add(new int[]{L, R});
            } else {
                mergeList.get(mergeList.size() - 1)[1] = Math.max(mergeList.get(mergeList.size() - 1)[1], R);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }

    public static void main(String[] args) {
        int test[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(test);
        System.out.println();

    }
}