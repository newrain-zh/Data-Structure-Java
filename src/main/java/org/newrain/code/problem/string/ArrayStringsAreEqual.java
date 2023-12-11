package org.newrain.code.problem.string;

/**
 * leetCode.1662 检查两个字符串数组是否相等
 * @author NewRain
 * @description 检查两个字符串数组是否相等
 * @link <a href="https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/"></a>
 * @tag 字符串 String
 */
public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1[0].charAt(0) != word2[0].charAt(0)) {
            return false;
        }
        StringBuilder s1 = new StringBuilder();
        for (String str : word1) {
            s1.append(str);
        }
        StringBuilder s2 = new StringBuilder();
        for (String str : word2) {
            s2.append(str);
        }
        return s1.toString().equals(s2.toString());
    }
}