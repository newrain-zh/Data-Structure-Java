package org.newrain.leetcode.problem.string;

import javax.print.DocFlavor;

/**
 * @author newRain
 * @description 反转字符串 II
 * @link <a href="https://leetcode.cn/problems/reverse-string-ii/"></a>
 */
public class LeetCode541 {


    public static String reverseStr(String s, int k) {
        //特殊情况
        if (k == 0) {
            return s;
        }
        if (k == s.length()) {
            return new StringBuilder(s).reverse().toString();
        }

        for (int i = 0; i < s.length(); i++) {
        }

        String substring = s.substring(0, k);
        String substring1 = s.substring(k);
        System.out.println(substring1);
        return new StringBuilder(substring).reverse().append(substring1).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
