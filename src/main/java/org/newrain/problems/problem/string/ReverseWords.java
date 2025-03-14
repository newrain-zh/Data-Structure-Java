package org.newrain.problems.problem.string;

/**
 * @author NewRain
 * @description 反转字符串中的单词
 * @link <a href="https://leetcode.cn/problems/reverse-words-in-a-string/submissions/">leetcode</a>
 * @link <a href="https://www.lintcode.com/problem/927/">lintcode</a>
 * @tag 字符串
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!"".equals(strArr[i])) {
                if (i == 0) {
                    stringBuilder.append(strArr[i].trim());
                } else {
                    stringBuilder.append(strArr[i].trim()).append(" ");
                }
            }
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
//        System.out.println(reverseWords("a good   example"));
//        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
    }
}