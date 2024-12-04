package org.newrain.code.problem.array;

public class NonnegativeSubarray {

    /**
     * @param nums: An integer array
     * @return: Length of non-negative subarray
     */
    public static int nonnegativeSubarray(int[] nums) {
        int ret = 0, temp = 0;
        for (int num : nums) {
            if (num >= 0) {
                temp++;
            } else {
                ret = Math.max(temp, ret);
                temp = 0;
            }
        }
        return Math.max(temp, ret);
    }

    public static void main(String[] args) {
        System.out.println(nonnegativeSubarray(new int[]{-1, -1, 1, -1, 1, 0, 1, -1, -1}));
    }
}