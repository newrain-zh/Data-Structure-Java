package org.newrain.code.problem.string;

/**
 * @author NewRain
 * @description 大小写转换 II
 * @link <a href="https://www.lintcode.com/problem/146/">lintcode</a>
 * @tag 字符串 String
 */
public class LintCode146 {

    public static String lowercaseToUppercase2(String letters) {
        char[] chars = letters.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] ^= 32;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(lowercaseToUppercase2("abc"));
    }
}
