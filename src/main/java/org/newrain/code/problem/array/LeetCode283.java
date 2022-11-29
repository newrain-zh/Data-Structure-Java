package org.newrain.code.problem.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author NewRain
 * @description 移动零
 * @link <a href="https://leetcode.cn/problems/move-zeroes/"></a>
 */
public class LeetCode283 {

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(index);
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{1, 0, 12, 0, 0});
    }
}
