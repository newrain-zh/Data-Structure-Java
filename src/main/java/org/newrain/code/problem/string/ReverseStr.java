package org.newrain.code.problem.string;

/**
 * leetcode.541 反转字符串II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        if (k == 0) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int step = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == (k * step)) {
                k++;

            } else {
                ans.append(s.indexOf(i));
            }
        }

        return "";

    }

}