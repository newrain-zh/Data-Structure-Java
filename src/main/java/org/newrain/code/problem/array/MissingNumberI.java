package org.newrain.code.problem.array;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 丢失的数字
 * @link <a href="https://leetcode.cn/problems/missing-number/"></>
 */
public class MissingNumberI {

    public static int missingNumber1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i != nums[i]) {
                if (i == 0) {
                    return 0;
                }
                return nums[i - 1] + 1;
            }
        }
        return nums[len - 1] + 1;
    }

    public static int missingNumber2(int[] nums) {
        //0 ^ 4 = 4
        //4 ^ 4 = 0
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            length ^= nums[i];
            length ^= i;
        }
        return length;
    }


    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{0, 1, 3}));
        System.out.println(missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}