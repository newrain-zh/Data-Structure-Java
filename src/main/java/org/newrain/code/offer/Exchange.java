package org.newrain.code.offer;

public class Exchange {

    public static int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1, tmp;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(5 & 1);
        System.out.println(4 & 1);
    }
}
