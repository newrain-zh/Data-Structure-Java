package org.newrain.code.problem.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonnegativeSubarrayI {


    /**
     * -1、0 和 1
     * 非负数 0
     *
     * @param nums: An integer array
     * @return: Length of non-negative subarray
     */
    public static int nonnegativeSubarray(int[] nums) {
        int sum = 0;
        int[] ans = new int[nums.length];
        int maxLen = 0;
        int prev = 0;
        Map<Integer, Integer> sumMap = new LinkedHashMap<>();
        Map<Integer, Integer> posMap = new LinkedHashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            if (sum >= 0) {
                sumMap.put(sum, i);
                posMap.put(sum, prev);
            } else {
                sum = 0;
                System.out.println("prev=" + prev + "curr=" + i);
                prev = i;

            }
        }
        System.out.println(sumMap);
        System.out.println(posMap);
        return 0;
    }


    public static void main(String[] args) {
//        System.out.println(nonnegativeSubarray(new int[]{-1, -1, 1, -1, 1, 0, 1, -1, -1}));//7
//        System.out.println(nonnegativeSubarray(new int[]{1, -1, 1, 1, -1})); //5
        int[] test = new int[]{-1, 0, -1, 1, -1, 0, -1, 0, 0, 1, 0, -1, 1, 1, -1, 0, -1, 1, -1, -1, -1, 0, -1, 1, 1, -1, -1, -1, -1, 0, -1, 0, -1, 0, 1, 1, 1, 1, 0, -1, 0, 1, 0, -1, -1, 1, -1, 1, 1, 0, 1, -1, -1, 1, -1, 0, -1, 0, 1, 0, 0, -1, 0, -1, 0, -1, -1, 1, 0, 1, -1, 0, -1, 1, -1, -1, 1, -1, 1, 1, -1, -1, 1, 0, 1, 1, 1, 1, 0, 0, -1, 0, 0, 1, -1, 1, 0, 1, -1, 0, -1, -1, -1, 0, 0, 0, 1, 0, -1, 0, 0, 1, 1, 0, 0, 1, 0, -1, 0, 1, 1, -1, 0, 1, -1, -1, -1, -1, 1, 0, 0, 0, -1, 1, 1, 0, 1, 0, 0, 0, -1, -1, 1, -1, 0, 0, 0};
        System.out.println(test.length);
        nonnegativeSubarray(test);

    }
}