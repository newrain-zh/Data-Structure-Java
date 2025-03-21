package org.newrain.problems.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：leetcode.2496 数组中字符串的最大值
 * 一个由字母和数字组成的字符串的 值 定义如下：
 * 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
 * 否则，值为字符串的 长度 。
 * 给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，请你返回 strs 中字符串的 最大值 。
 * 示例 1：
 * 输入：strs = ["alic3","bob","3","4","00000"]
 * 输出：5
 * 解释：
 * - "alic3" 包含字母和数字，所以值为长度 5 。
 * - "bob" 只包含字母，所以值为长度 3 。
 * - "3" 只包含数字，所以值为 3 。
 * - "4" 只包含数字，所以值为 4 。
 * - "00000" 只包含数字，所以值为 0 。
 * 所以最大的值为 5 ，是字符串 "alic3" 的值。
 * 提示：
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 9
 * strs[i] 只包含小写英文字母和数字。
 */
public class MaximumValue {

    public static void main(String[] args) {
//        System.out.println(maximumValue(new String[]{"alic3", "bob", "3", "4", "00000"}));
        System.out.println(maximumValue(new String[]{"1", "01", "001", "0001"}));
    }

    public static int maximumValue(String[] strs) {
        Set<Character> set = new HashSet<>(10);
        for (int i = 0; i < 10; i++) {
            set.add((char) (i + '0')); //数字转char
        }
        int ans = 0;
        for (String str : strs) {
            ans = Math.max(getNumber(str.toCharArray(), set), ans);
        }
        return ans;
    }

    public static int getNumber(char[] chars, Set<Character> dict) {
        if (chars.length == 1) {
            if (dict.contains(chars[0])) {
                return Character.digit(chars[0], 10);//char 转数字
            }
        }
        int len = 0;
        for (char aChar : chars) {
            if (dict.contains(aChar)) {
                len++;
            }
        }
        if (len == chars.length) {//说明字符为全数字
            //有些数字例如00001 转换为数字1
            //这里是省略了实现
            return Integer.parseInt(new String(chars));
        }
        return chars.length;
    }
}