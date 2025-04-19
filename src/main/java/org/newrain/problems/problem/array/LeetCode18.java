package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode.18 四数之和
 * Tag: 双指针
 */
public class LeetCode18 {


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans    = new ArrayList<>();
        int                 length = nums.length;
        if (length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        // nums[i] + nums[j] + nums[left] + nums[right]  = target
        // for i     for j     left         right
        for (int i = 0; i < length - 3; i++) { // 第一层 for 循环控制
            if (i > 0 && nums[i] == nums[i - 1]) { // 跳过重复的起始元素
                continue;
            }
            // 如果当前值（最小值）+后面三个元素的值大于 target 则说明不可能有元素
            //
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 当前元素和最大的三个数 都小于 target
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) { // 如果当前 i
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { //  跳过重复的 第二个元素
                    continue;
                }
                // 如果当前值（最小值）+后面三个元素的值大于 target 则说明不可能有元素
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // i + j + 两个最大数 小于 target 说明当前的 nums[j]
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) { // 如果当前 i
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        System.out.println("=====");
        int[] ints = {-3, -2, -1, 0, 0, 1, 2, 3};
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
        //  i   j   l               r
        // [-3, -2, -1, 0, 0, 1, 2, 3]
        //  第一轮 -3+-2+-1+3 = -3 -3< target(0)
        //  i   j       l            r
        // [-3, -2, -1, 0, 0, 1, 2, 3]
        //  第二轮 -3+-2+0+3 = -3 -2 < target(0)
    }
}