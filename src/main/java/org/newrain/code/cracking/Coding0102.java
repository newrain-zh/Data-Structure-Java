package org.newrain.code.cracking;

import java.util.Arrays;

/**
 * @author newrain
 * @description 面试题 01.02. 判定是否互为字符重排
 * @see <a href="https://leetcode.cn/problems/check-permutation-lcci/"></a>
 */
public class Coding0102 {

    public static boolean checkPermutation(String s1, String s2) {
        //check
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);

        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }

    /**
     * 利用 ASCII 计数
     */
    public static boolean checkPermutationByAscii(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        //字母计数 如果两个字符串都出现该字母
        //相互抵消 则cnt数组响应的位置的数字为0
        int[] cnt = new int[128];
        for (char ch : s1.toCharArray()) {
            cnt[ch - 'a']++;
        }
        for (char ch : s2.toCharArray()) {
            cnt[ch - 'a']--;
        }

        for (int j : cnt) {
            if (j != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(checkPermutationByAscii("ac", "bb"));
        int a = 'a' + 'b';
        int b = 'b' + 'b';
        System.out.println(a);
        System.out.println(b);

    }
}
