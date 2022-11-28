package org.newrain.leetcode.problem.string;

/**
 * @author NewRain
 * @description 检查单词是否为句中其他单词的前缀
 * @tag string
 */
public class LeetCode1455 {


    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
