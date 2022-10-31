package org.newrain.leetcode.problem.string;

public class LeetCode151 {
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
