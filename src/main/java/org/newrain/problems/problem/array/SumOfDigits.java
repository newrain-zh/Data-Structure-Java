package org.newrain.problems.problem.array;

public class SumOfDigits {


    /**
     * @param nums: An array
     * @return: Sum of Digits in the Minimum Number is Even or Not
     */
    public static boolean sumOfDigits(int[] nums) {
        int number = Integer.MAX_VALUE;
        for (int num : nums) {
            number = Math.min(num, number);
        }
        if (number < 10) return number % 2 == 0;
        int ans = 0;
        while (number > 0) {
            int digit = number % 10;
            ans += digit;
            number /= 10;
        }
        return ans % 2 == 0;
    }

    public static void main(String[] args) {
//        Assert.assertFalse(sumOfDigits(new int[]{20, 10, 15, 19}));
//        Assert.assertTrue(sumOfDigits(new int[]{2147483647}));
        System.out.println(sumOfDigits(new int[]{2147483647}));
    }

}