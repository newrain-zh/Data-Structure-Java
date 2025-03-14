package org.newrain.problems.offer;

public class Offer42 {


    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = new int[]{-2, -1};
        System.out.println(maxSubArray(arr));
    }
}