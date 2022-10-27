package org.newrain.leetcode.offer;

public class Offer53 {


    public int search(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            if (num == target) {
                sum++;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8};
    }

}
