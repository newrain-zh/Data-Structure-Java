package org.newrain.code.problem.array;


import java.util.HashMap;
import java.util.Map;

/**
 * 题目： leetcode.1640 能否连接形成数组
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 */
public class CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>(pieces.length);
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0, n = arr.length;
        while (i < n) {
            //是否存在以arr[i]开头的数组
            if (!map.containsKey(arr[i])) {
                return false;
            }
            //存在，开始遍历数组中每个元素是否匹配
            int[] curArr = map.get(arr[i]);
            for (int value : curArr) {
                if (arr[i++] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}