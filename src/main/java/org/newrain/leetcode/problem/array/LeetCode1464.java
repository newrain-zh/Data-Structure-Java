package org.newrain.leetcode.problem.array;

/**
 * @author newRain
 * @description 数组中两元素的最大乘积
 * @link <a href="https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/><a/>
 * @tag array
 */
public class LeetCode1464 {


    public static int maxProduct(int[] nums) {
        int n1 = 0, n2 = 0;
        for (int num : nums) {
            if (num > n1) {
                n2 = n1;
                n1 = num;
            } else if (num > n2) {
                n2 = num;
            }
        }
        return (n1 - 1) * (n2 - 1);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3, 4, 5, 2}));
        System.out.println(maxProduct(new int[]{1, 5, 4, 5}));
    }
}
