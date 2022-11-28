package org.newrain.leetcode.problem.string;

/**
 * @author NewRain
 * @description 交替合并字符串
 * @link <a href="https://leetcode.cn/problems/merge-strings-alternately/">leetcode</a>
 * @tag 字符串 String
 */
public class LeetCode1768 {

    public static String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2;
        }
        if (word2 == null || word2.length() == 0) {
            return word1;
        }
        int minLen = Math.min(word1.length(), word2.length());
        String merge = merge(word1.substring(0, minLen), word2.substring(0, minLen));
        if (word1.length() > minLen) {
            merge += word1.substring(minLen);
        }
        if (word2.length() > minLen) {
            merge += word2.substring(minLen);
        }
        return merge;

    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    public static String merge(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            builder.append(chars1[i]).append(chars2[i]);
        }
        return builder.toString();


    }


}
