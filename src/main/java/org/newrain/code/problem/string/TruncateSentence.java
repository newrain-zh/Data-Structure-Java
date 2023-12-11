package org.newrain.code.problem.string;

/**
 * leetcode.1816 截断句子
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 *
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 *
 * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，
 * 请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。
 *
 * 返回 截断 s​​​​​​ 后得到的句子。
 * @author NewRain
 */
public class TruncateSentence {


    public static String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        if (k == 0) {
            return s1[0];
        }
        if (k == s1.length) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            result.append(s1[i]);
            if (i + 1 != k) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 5));
    }
}