package org.newrain.code.problem.string;

/**
 * @author NewRain
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
        int pos = 0;
        StringBuilder str = new StringBuilder();
        StringBuilder curr = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            if (pos == 2 * k) {
                str.append(curr.append(s.substring(i - k, i)).reverse());
                curr = new StringBuilder();
                pos = 1;
            }
            pos++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
