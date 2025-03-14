package org.newrain.problems.problem.array;

/**
 *
 * leetcode.LCP 06. 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，
 * 拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 */
public class MinCount {


    public static int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            if (coin >= 2) {
                if ((coin & 1) == 0) {//为偶数 说明可以被2整除 直接获取商
                    ans = ans + coin / 2;
                } else {
                    ans = ans + 1 + (coin / 2);
                }
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static int minCount1(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            if ((coin & 1) == 0) {//为偶数 说明可以被2整除 直接获取商
                ans = ans + coin / 2;
            } else {
                ans = ans + 1 + (coin / 2);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minCount1(new int[]{4, 2, 1}));//4
        System.out.println(minCount1(new int[]{2, 3, 10}));//8
    }
}