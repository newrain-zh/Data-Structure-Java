package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组，找到和为0的子数组。
 * 你的代码应该返回满足要求的子数组的起始位置和结束位置
 */
public class SubarraySum {


    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public static List<Integer> subarraySum(int[] nums) {
        List<Integer> ans = new ArrayList<>(2);
        Map<Integer, Integer> sumMap = new LinkedHashMap<>(nums.length);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                ans.add(0);
                ans.add(i);
                return ans;
            } else if (sumMap.containsKey(sum)) {//说明之前的数组出现过为0的值
                ans.add(sumMap.get(sum) + 1);
                ans.add(i);//
                return ans;
            }
            sumMap.put(sum, i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{-3, 1, 2, -3, 4}).toString());
//        System.out.println("-3, 1, -4, 2, -3, 4");
//        subarraySum(new int[]{-3, 1, -4, 2, -3, 4});
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1, 2}));
    }
}