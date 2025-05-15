package org.newrain.problems.problem.array;

/**
 * @author NewRain
 * @link <a href="https://www.lintcode.com/problem/479">lintcode</a>
 * @description 数组第二大数
 */
public class SecondMax {


    public static int secondMax(int[] nums) {
        // write your code here
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int max = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] >= max) {
                second = max;
                max = nums[i];
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondMax(new int[]{1, 3, 2, 4}));
        System.out.println(secondMax(new int[]{1, 1, 2, 2}));
        System.out.println(secondMax(new int[]{1, -1, -2}));
    }
}