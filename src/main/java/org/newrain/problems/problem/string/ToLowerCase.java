package org.newrain.problems.problem.string;

/**
 * @author NewRain
 * @description 转换成小写字母
 * @link <a href="https://leetcode.cn/problems/to-lower-case/">leetcode</a>
 * @link <a href="https://www.lintcode.com/problem/1535/">lintcode</a>
 * @tag 字符串 String
 */
public class ToLowerCase {


    public static String toLowerCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] r = new char[str.length()];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                r[i] = chars[i] |= 32;
            } else {
                r[i] = chars[i];
            }
        }
        return new String(r);
    }


    public static String toLowerCase1(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] r = new char[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                r[i] = chars[i] |= 32;
            } else {
                r[i] = chars[i];
            }
        }
        return new String(r);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase1("HEllo@[]"));
        int charA = 'a';
        int chara = 'z';
        System.out.println(charA);
        System.out.println(chara);
    }
}