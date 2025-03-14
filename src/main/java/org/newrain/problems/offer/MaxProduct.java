package org.newrain.problems.offer;

public class MaxProduct {

    /**
     * 暴力破解
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int pre = 1;
            for (int j = i; j < nums.length; j++) {
                pre = pre * nums[j];
                max = Math.max(pre, max);
            }
        }
        return max;
    }

    public static int maxProductDp(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(minDP[i - 1] * nums[i], Math.min(nums[i], maxDP[i - 1] * nums[i]));
        }
        int res = maxDP[0];
        for (int i = 1; i < maxDP.length; i++) {
            res = Math.max(res, maxDP[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println(maxProduct(new int[]{0, 2, 0, 4}));
//        System.out.println(maxProduct(new int[]{3, -1, 4}));
//        System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));
//        System.out.println(maxProductDp(new int[]{2, -5, -2, -4, 3}));
        System.out.println(maxProductDp(new int[]{2, -1, 1, 1}));

    }
}