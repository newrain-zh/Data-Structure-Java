package org.newrain.code.problem.array;

import java.util.*;

/**
 * 题目：leetcoode.2094 找出 3 位偶数
 * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 * TODO 该题目也可使用回溯算法 待后面补充
 */
public class FindEvenNumbers {


    /**
     * 暴力枚举
     *
     * @param digits
     * @return
     */
    public static int[] findEvenNumbers1(int[] digits) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && k != i && digits[i] != 0 && (digits[k] & 1) == 0) {
                        ans.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }
        List<Integer> integers = new ArrayList<>(ans);
        int[] ret = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ret[i] = integers.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }

    /**
     * 最优解 TODO 待解析
     *
     * @param digits
     * @return
     */
    public int[] findEvenNumbers(int[] digits) {
        //1.头不为0，尾部为偶数，递增
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        for (int i = 100; i < 1000; i += 2) {

            int[] count1 = new int[10];
            boolean ok = true;
            int x = i;
            while (x > 0) {
                int cur = x % 10;
                count1[cur]++;
                if (count1[cur] > count[cur]) {//该偶数不存在
                    ok = false;
                    break;
                }
                x /= 10;
            }
            if (ok) {
                ans.add(i);//该偶数可组成
            }
        }
        int len = ans.size();
        final int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        //102,120,130,132,210,230,302,310,312,320
        System.out.println(Arrays.toString(findEvenNumbers1(new int[]{2, 1, 3, 0})));
    }
}