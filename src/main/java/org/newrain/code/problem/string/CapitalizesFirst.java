package org.newrain.code.problem.string;

/**
 * @author NewRain
 * @description 首字母大写
 * @link <a href="https://www.lintcode.com/problem/936/">lintcode</a>
 * @tag String
 */
public class CapitalizesFirst {


    /**
     * @param s: a string
     * @return a string after capitalizes the first letter
     */
    public static String capitalizesFirst(String s) {
        // Write your code here
        char[] chars = s.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] &= -33;
        }
        for (int i = 1; i < s.length(); i++) {
            //如果当前字符串前面为空格且自己本身不为空格
            if (chars[i - 1] == ' ' && chars[i] != ' ') {
                chars[i] &= -33;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
//        System.out.println(capitalizesFirst("i want to get an accepted"));
        System.out.println(capitalizesFirst("euiorwusyyiufiewoyofs "));
    }
}