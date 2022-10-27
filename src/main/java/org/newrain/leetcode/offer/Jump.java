package org.newrain.leetcode.offer;


public class Jump {

    public static int jump(int[] nums) {
        //首先判断边界和特殊情况
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 && nums[0] != 0) {
            return 1;
        }
        //记录步数
        int steps = 0;
        //记录最大步数
        int maxJump = 0;
        //记录每次跳跃的位置
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //获取最大跳跃步数
            maxJump = Math.max(maxJump, nums[i] + i);
            //当前数组的索引位置等于上次跳跃的最大位置
            if (i == end) {
                //将end 指针移到最大的跳跃位置 同时步数要增加 表示已经跳跃到该位置
                end = maxJump;
                steps++;
            }

        }
        return steps;
    }

    public static void main(String[] args) {
//        int[] test = new int[]{2, 3, 1, 1, 4};
        int[] test = new int[]{2, 1};
        System.out.println(jump(test));
    }
}
