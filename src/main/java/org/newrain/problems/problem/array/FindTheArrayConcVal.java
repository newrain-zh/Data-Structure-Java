package org.newrain.problems.problem.array;


/**
 * 题目：leetcode.2562 找出数组的串联值
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 现定义两个数字的 串联 是由这两个数值串联起来形成的新数字。
 * 例如，15 和 49 的串联是 1549 。
 * nums 的 串联值 最初等于 0 。执行下述操作直到 nums 变为空：
 * 如果 nums 中存在不止一个数字，分别选中 nums 中的第一个元素和最后一个元素，将二者串联得到的值加到 nums 的 串联值 上，然后从 nums 中删除第一个和最后一个元素。
 * 如果仅存在一个元素，则将该元素的值加到 nums 的串联值上，然后删除这个元素。
 * 返回执行完所有操作后 nums 的串联值。
 */
public class FindTheArrayConcVal {


    public static long findTheArrayConcVal(int[] nums) {
        int l = 0, r = nums.length - 1;
        long ans = 0L;
        while (l < r) {
            String num1 = Integer.toString(nums[l]);
            String num2 = Integer.toString(nums[r]);
            ans += Long.parseLong(num1 + num2);
            l++;
            r--;
        }
        if ((nums.length & 1) == 1) {
            ans = ans + nums[nums.length / 2];
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(findTheArrayConcVal(new int[]{7, 52, 2, 4}));//596
        System.out.println(findTheArrayConcVal(new int[]{5, 14, 13, 8, 12}));
    }

}