package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode.57 插入区间
 * @author NewRain
 * @description LeetCode57
 */
public class Insert {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) {
            return new int[0][0];
        }
        //先将二维数组中的数组第一个数进行排序
        //这样做的好处是减少判断，只要判断相邻的两个位置是不是重叠区间就可以了
        //[0] [1] 两个位置不在一个区间 就不用判断后续了
        int[][] args = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            System.arraycopy(intervals[i], 0, args[i], 0, intervals[i].length);
        }
        args[args.length - 1] = newInterval;
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
        int[][] array = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        insert(array, newInterval);
    }
}