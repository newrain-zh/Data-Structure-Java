package org.newrain.problems.problem.array;

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

    /**
     * 与merge1 思路相同 都是借助排序的方式，只是写法不同而已
     * @param intervals
     * @return
     */
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

    public static int[][] merge1(int[][] args) {
        if (args.length == 0) {
            return new int[0][0];
        }
        //先将二维数组中的数组第一个数进行排序
        //这样做的好处是减少判断，只要判断相邻的两个位置是不是重叠区间就可以了
        //[0] [1] 两个位置不在一个区间 就不用判断后续了
        Arrays.sort(args, Comparator.comparingInt(interval -> interval[0]));
        //保存结果集
        List<int[]> result = new ArrayList<>();
        for (int[] arr : args) {
            int l = arr[0];
            int r = arr[1];
            //判断不重叠情况
            //result.size() == 0 直接添加原二维数组的第一个元素，
            //后续元素会和前面的元素来判断是否重叠
            //如果当前数组元素的值的最小值大于上个上个区间的最大值，说明不在一个区间范围内，可直接添加进数组
            if (result.isEmpty() || result.get(result.size() - 1)[1] < l) {
                result.add(new int[]{l, r});
            } else {
                //重叠情况就要和上一元素做对比 因为数组是排序的，只要取出上一个元素的最小值，还有重叠区间的最大值 组成新的区间值
                //并设置数组上个位置的元素为该新值
                int rightVal = result.get(result.size() - 1)[1];
                int val = Math.max(rightVal, r);
                result.set(result.size() - 1, new int[]{result.get(result.size() - 1)[0], val});
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] test = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(test);
        System.out.println();

    }
}