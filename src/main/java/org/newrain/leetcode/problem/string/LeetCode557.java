package org.newrain.leetcode.problem.string;

/**
 * @author NewRain
 * @description 反转字符串中的单词 III
 * @link <a herf="https://leetcode.cn/problems/reverse-words-in-a-string-iii/"></a>
 */
public class LeetCode557 {


    public static String reverseWords(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if (!s.contains(" ")) {
            return new StringBuilder(s).reverse().toString();
        }
        String[] s1 = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            if (" ".equals(s1[i])) {
                result.append(" ");
            } else {
                result.append(new StringBuilder(s1[i]).reverse());
                if (i != s1.length - 1) {
                    result.append(" ");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" God Ding"));
    }
}
