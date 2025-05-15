package org.newrain.problems.problem.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：leetcode.2553 分割数组中数字的数位
 * 给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。
 * 对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。
 * 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。
 */
public class SeparateDigits {

    /**
     * 不是最优解
     *
     * @param nums
     * @return
     */
    public static int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num < 10) {
                list.add(num);
            } else {
                char[] charArray = String.valueOf(num).toCharArray();
                for (char c : charArray) {
                    list.add(Character.digit(c, 10));
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 最优解法思路
     */
    private void better() {
        int num = 10921;
        int n = num;
        while (n > 10) {
            int s = n % 10; //获取个位、十位
            n /= 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[]{13, 25, 83, 77})));
//        System.out.println(10921 / 10);
//        System.out.println(10921 % 10);
    }
}