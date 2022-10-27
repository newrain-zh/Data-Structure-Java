package org.newrain.leetcode.offer;

public class CanJump {

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= step) {
                System.out.println("step:" + step + ":" + (i + nums[i]));
                step = Math.max(step, i + nums[i]);
            }
        }
        System.out.println(step);
        return step >= nums.length - 1;
    }

    public static boolean canJump1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int step = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == step) {
                sum = sum + nums[i];
                step = sum;
            }
        }
        System.out.println(step);
        System.out.println(sum);
        return sum >= nums.length - 1;
    }

    public static void main(String[] args) {
//        System.out.println(canJump(new int[]{2,3,1,1,4}));
//        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

}
