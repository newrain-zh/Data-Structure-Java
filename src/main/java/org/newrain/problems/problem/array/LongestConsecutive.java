package org.newrain.problems.problem.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 */
public class LongestConsecutive {


    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            set.add(n);
        }
        int longestConsecutive = 0;
        for (int number : set) {
            //检测自增
            if (!set.contains(number - 1)) {
                int currConsecutive = 1;
                int currNum = number + 1;
                while (set.contains(currNum)) {
                    currConsecutive++;
                    currNum++;
                }
                longestConsecutive = Math.max(longestConsecutive, currConsecutive);
            }
        }
        return longestConsecutive;
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int maxLength = 1;
        int currLength = 1;
        for (int i = 1; i < nums.length; i++) {
            //忽略不需要检测的数组
            if (nums[i] <= nums[i - 1]) {
                continue;
            }
            if (nums[i] - 1 == nums[i - 1]) {
                ++currLength;
            } else {
                maxLength = Math.max(maxLength, currLength);
                currLength = 1;
            }
        }
        //这里max函数 如果数组一直递增 循环里无法更新maxLength变量
        return Math.max(maxLength, currLength);

    }


    public static void main(String[] args) {
//        System.out.println(longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2}));
//        System.out.println(longestConsecutive2(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive2(new int[]{1, 2, 0, 1}));
//        System.out.println(longestConsecutive2(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

    }
}