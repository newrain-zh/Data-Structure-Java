package org.newrain.problems.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：leetcode.1684 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * 请你返回 words 数组中 一致字符串 的数目。
 */
public class CountConsistentStrings {

    /**
     * 使用set集合
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        char[] charArray = allowed.toCharArray();
        Set<Character> set = new HashSet<>(allowed.length());
        for (char c : charArray) {
            set.add(c);
        }
        int ans = 0;
        for (String word : words) {
            char[] charArray1 = word.toCharArray();
            boolean isOk = true;
            for (char c : charArray1) {
                if (!set.contains(c)) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 使用字典方式
     * 核心代码都已实现，
     * TODO 具体代码待完善
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings1(String allowed, String[] words) {
        int[] isAllowed = new int[26];
        char[] charArray = allowed.toCharArray();
        int ans = 0;
        for (char c : charArray) {
            isAllowed[c - 'a']++;
        }
        return ans;

    }
}