package org.newrain.code.problem.array;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 删除有序数组中的重复项 II
 * @link <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">...</a>
 * @complexity middle
 */
public class LeetCode80 {

    /**
     * 快慢指针算法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
