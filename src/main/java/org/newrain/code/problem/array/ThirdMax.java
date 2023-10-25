package org.newrain.code.problem.array;

public class ThirdMax {


    /**
     * @param nums: the array
     * @return: the third maximum number in this array
     */
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (num < a && num > b) {
                c = b;
                b = num;
            } else if (num < b && num > c) {
                c = num;
            }
        }
        //有没有第三大的数
        return (int) (c == Long.MIN_VALUE ? a : c);
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1, 2, 3})); //1
        System.out.println(thirdMax(new int[]{1, 2}));//2
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));//1
        System.out.println(thirdMax(new int[]{-2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1}));//1
        System.out.println(thirdMax(new int[]{1, 2, -2147483648}));
    }
}