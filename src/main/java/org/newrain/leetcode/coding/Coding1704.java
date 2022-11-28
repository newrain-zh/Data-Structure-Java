package org.newrain.leetcode.coding;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 消失的数字
 */
public class Coding1704 {


    /**
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                //消失的数字比当前的位置大
                if (nums[i] > i) {
                    return nums[i] - 1;
                } else {
                    return nums[i] + 1;
                }
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
    }

}
