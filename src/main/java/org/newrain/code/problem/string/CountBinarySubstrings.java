package org.newrain.code.problem.string;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode.696 计数二进制子串
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * <p>
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * 示例1:
 * <p>
 * 输入：s = "00110011"
 * <p>
 * 输出：6
 * <p>
 * 解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * <p>
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * <p>
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 * 2,2,2,2
 */
public class CountBinarySubstrings {

    /**
     * 这个不是最优解
     * 00110011 转换为[2,2,2,2]
     * 然后求出 min(i,i+1)
     *
     * @param s
     * @return
     */
    public static int countBinarySubstrings(String s) {
        StringBuilder stack = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.length() == 0) {
                stack.append(c);
                continue;
            }
            if (stack.charAt(stack.length() - 1) == c) {
                stack.append(c);
            } else {
                list.add(stack.length());
                stack.delete(0, stack.length());
                stack.append(c);
            }
        }
        if (stack.length() > 0) {
            list.add(stack.length());
        }
        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            ans += Math.min(list.get(i - 1), list.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}