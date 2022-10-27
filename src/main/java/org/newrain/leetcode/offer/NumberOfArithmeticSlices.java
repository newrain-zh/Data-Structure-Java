package org.newrain.leetcode.offer;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * 等差数列的子数组的个数规律 (n-1)*(n-2)/2
 * 这里的n为数组长度
 * <p>
 * 从长度为4开始
 * total = 上一个等差数列的个数+上上个等差数列的长度
 */
public class NumberOfArithmeticSlices {

    /**
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        //差值
        int diff = nums[1] - nums[0];
        int sum = 0;
        int total = 0;
        for (int i = 2; i < nums.length; i++) {
            //如果是等差数列
            if (nums[i] - nums[i - 1] == diff) {
                sum++;
            } else {
                sum = 0;
                diff = nums[i] - nums[i - 1];
            }
            total += sum;
            System.out.println("长度：" + (i + 1) + " total:" + total + " sum " + sum);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(numberOfArithmeticSlices(test));
    }


}
