package org.newrain.code.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindErrorNums {


    /**
     * 排序法
     *
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
    public static int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int prev = 0;
        for (int curr : nums) {
            if (curr == prev) { //重复的
                ans[0] = curr;
            } else if (curr - prev > 1) {//说明不是递增为1
                ans[1] = prev + 1;
            }
            prev = curr;
        }
        //判断数组最后一位
        if (nums[nums.length - 1] != nums.length) {
            ans[1] = nums.length;
        }
        return ans;
    }

    public static int[] findErrorNums2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                ans[0] = i;
            } else if (count == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
//        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums2(new int[]{1, 1})));//1,2
    }

}