package org.newrain.leetcode.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author newrain
 */
public class LeetCode56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> mergeList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (mergeList.size() == 0 || mergeList.get(mergeList.size() - 1)[1] < L) {
                mergeList.add(new int[]{L, R});
            }else {
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
