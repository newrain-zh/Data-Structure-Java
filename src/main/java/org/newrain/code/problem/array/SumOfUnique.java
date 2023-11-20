package org.newrain.code.problem.array;

/**
 * 唯一元素的和
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的 和 。
 */
public class SumOfUnique {

    public static int sumOfUnique(int[] nums) {
        int[] dict = new int[101];
        for (int num : nums) {
            if (dict[num] > 0) { //已经出现该数
                dict[num] = -1;
            } else {
                if (dict[num] == 0) {//必须相应的位置为0 表示未出现过该数
                    dict[num] = num; //将唯一数写到数组的相应位置
                }
            }
        }
        int ans = 0;
        for (int j : dict) {
            if (j > 0) {
                ans += j;
            }
        }
        return ans;
    }

    /**
     * 与上述解法思路相同 都是通过数组构建一个计数器
     * cnt 记录了0-100中的每个数字出现的次数
     *
     * @param nums
     * @return
     */
    public static int sumOfUnique2(int[] nums) {
        int[] cnt = new int[101];
        for (int x : nums) {
            cnt[x]++;
        }
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (cnt[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
//        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
//        System.out.println(sumOfUnique(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(sumOfUnique(new int[]{1, 1, 1, 1, 1}));
        System.out.println(sumOfUnique(new int[]{14, 83, 63, 42, 15, 87, 61, 37, 30, 95, 99, 100, 45, 30, 5, 2, 29, 65, 15, 71, 12, 17, 61, 81}));
    }
}