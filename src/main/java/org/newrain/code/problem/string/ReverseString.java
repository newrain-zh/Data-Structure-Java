package org.newrain.code.problem.string;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 翻转字符串
 * @link <a href="https://www.lintcode.com/problem/1283">lintcode</a>
 */
public class ReverseString {

    public static void reverseString(char[] chars) {
        char temp;
        int len = chars.length / 2;
        for (int i = 0; i < len; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(chars));
    }

    /**
     * @param s: a string
     * @return return a string
     */
    public static String reverseString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        reverseString("hello".toCharArray());
        System.out.println(reverseString("hello"));
        System.out.println(5 / 2);
    }

}