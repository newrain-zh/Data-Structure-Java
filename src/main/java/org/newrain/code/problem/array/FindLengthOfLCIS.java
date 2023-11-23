package org.newrain.code.problem.array;

/**
 *
 * 题目：最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLengthOfLCIS {


    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int count = 1, max = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                count = count + 1;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
            pre = nums[i];
        }
        return Math.max(count, max);
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5}));
    }
}