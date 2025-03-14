package org.newrain.problems.problem.array;


/**
 * 题目：leetcode.1961 检查字符串是否为数组前缀
 * 给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
 * 字符串 s 要成为 words 的 前缀字符串 ，
 * 需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
 * 如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
 */
public class IsPrefixString {


    public static boolean isPrefixString(String s, String[] words) {
        String temp = "";
        for (String word : words) {
            temp += word;
            if (s.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPrefixString("iloveleetcode", new String[]{"i", "love", "leetcode", "apples"}));
        System.out.println(isPrefixString("iloveleetcode", new String[]{"apples", "i", "love", "leetcode"}));

    }
}