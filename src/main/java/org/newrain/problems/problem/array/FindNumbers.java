package org.newrain.problems.problem.array;

/**
 * leetcode.1295 统计位数为偶数的数字
 *
 */
public class FindNumbers {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            String str = num + "";
            if (str.length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static int findNumbers1(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (((int)Math.log10(num) + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(findNumbers1(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(Math.log10(7896));
    }
}