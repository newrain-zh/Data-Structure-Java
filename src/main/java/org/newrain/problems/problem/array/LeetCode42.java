package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * LeetCode42.接雨水
 */
public class LeetCode42 {

    /*
       height = [4,2,0,3,2,5]

     */
    public static int trap(int[] height) {

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }


        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(rightMax));
        return ans;
    }

    /*
    TODO 单调栈解法
     */
    public static int trap1(int[] height) {

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }


        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(rightMax));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
    }
}