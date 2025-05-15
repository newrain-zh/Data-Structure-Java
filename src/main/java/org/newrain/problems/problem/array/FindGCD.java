package org.newrain.problems.problem.array;


/**
 * 题目：leetcode.1979 找出数组的最大公约数
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 * <p>
 * 公约数是指能够同时整除两个或多个数的正整数
 */
public class FindGCD {

    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{2, 5, 6, 9, 10}));
    }

    public static int findGCD(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        //求最大公约数
        return gcd(min, max);

    }

    /**
     * 欧几里得算法（辗转相除法）来求解最大公约数。算法的基本思想是
     * ,用较小数除以较大数，然后用除数除以余数，
     * 再用余数除以新的余数，依此类推，直到余数为0。最后的除数就是最大公约数
     * 假设要求解两个数a = 48和b = 30的最大公约数。按照欧几里得算法的步骤进行计算：
     * 用30去除48，得到商1和余数18。
     * 用18去除30，得到商0和余数18。
     * 用18去除30，得到商0和余数12。
     * 用12去除18，得到商0和余数12。
     * 用12去除18，得到商0和余数6。
     * 用6去除12，得到商0和余数6。
     * 用6去除12，得到商0和余数0。
     *
     * @param a
     * @param b
     * @return
     */

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}