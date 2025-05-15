package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 翻转数组
 * @link <a href="https://www.lintcode.com/problem/767">lintcode</a>
 * @tag 数组 Array
 */
public class ReverseArray {

    public static void reverseArray(int[] nums) {
        // write your code here
        int middle = (nums.length / 2);
        for (int i = 0; i < middle; i++) {
            int tempValue = nums[i];
            nums[i] = nums[(nums.length - 1) - i];
            nums[(nums.length - 1) - i] = tempValue;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        reverseArray(new int[]{1, 2, 3, 4});
        reverseArray(new int[]{1, 2, 5});
    }
}