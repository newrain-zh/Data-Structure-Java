package org.newrain.code.problem.array;


import java.util.Arrays;

/**
 * 题目：重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */
public class Shuffle {

    /**
     * 该题的解法还有很多，例如
     * 1.构建数组 通过奇偶数 来取源数组不同位置的值
     * 2.或者将源数组拆分
     *
     * @param nums
     * @param n
     * @return
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            //每次赋值相邻的2个值
            //如（0，1）（2，3） x的值取源数组的值 并在该位置上加上n 得到y的值
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[i + n];
        }
        return ans;
    }

    public static void main(String[] args) {
        //2,3,5,4,1,7
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

}