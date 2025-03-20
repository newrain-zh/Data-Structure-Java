package org.newrain.problems.problem.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/">...</a>
 */
public class LeetCode452 {


    /**
     * [xstart,xend] 这里有两种办法 按 xstarth 或 xend排序
     * 优先建议用 xend排序
     * <p>
     * 如果是按 xstart排序，也就是按左排序，那么遍历的时候发现无需射箭的时候，需要更新 全局的xend的最小值，
     * 也就是说能xend最小能覆盖的区间最多，这样才能保证射箭的次数最少。
     * 如果是按 xend排序，那么xend已经从最小值往最大值排序，那么每次选择的箭位置都是最优的，
     * <p>
     * 按 xstart 排序可行，但需在遍历时动态调整 current_end 为更小的 xend，确保箭覆盖最多的气球。
     * 按 xend 排序更优：天然保证每次选择的箭位置最优，代码更简洁。建议优先采用。
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points.length == 1) {
            return points.length;
        }
        // 按左端点排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int arrowCount = 1;
        int rightPoint = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i]; // 当前点
            int currentLeftPoint = point[0]; // 当前的左端点
            int currentRightPoint = point[1]; // 当前的右端点
            if (currentLeftPoint > rightPoint) { // 如果当前点的左端点大于全局的右端点，则需要射箭
                arrowCount++;
                rightPoint = currentRightPoint;
            } else {
                rightPoint = Math.min(rightPoint, currentRightPoint); // 更新全局的右端点
            }
        }
        return arrowCount;
    }

    /**
     * 原始数组 int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}
     * 按照右端点排序[[1, 6], [2, 8], [7, 12], [10, 16]]
     * <p>
     * 在坐标系大概如下示
     * 1   6  <- 数组 0 号位置 标志数组
     * 2    8
     * 7    12
     * 10    16
     * 按右端点排序 如果下一个的左端点 判断是否处于上个数组的值中间 如果处于上个数组的区间之内，
     * 则不需要射箭 也不需要更新全局右端点。因为是按照右端点排序的，所以想要尽可能的少射箭，
     * 下一个数组的左端点必须要小于标志数组的右端点 ，也就是说你要射出最少的箭，需要尽可能的靠左
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots1(int[][] points) {
        if (points.length == 0 || points.length == 1) {
            return points.length;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // 按右端点排序
        int res = 1;
        int rightPoint = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > rightPoint) { // 如果当前点的左端点大于全局的右端点，则需要射箭
                res++;
                rightPoint = point[1]; // 更新全局的右端点
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(findMinArrowShots1(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}})); // 2
//        System.out.println(findMinArrowShots1(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}})); // 4
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 10}, {3, 4}, {4, 5}})); // 2
        System.out.println(findMinArrowShots1(new int[][]{{1, 2}, {2, 10}, {3, 4}, {4, 5}})); // 2
       /* int[][] arr = new int[][]{{7, 16}, {2, 8}, {1, 6}, {7, 12}};
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(arr));*/
    }
}