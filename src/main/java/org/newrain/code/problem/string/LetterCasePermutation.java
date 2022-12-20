package org.newrain.code.problem.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * @description 字母大小写转换
 * @tag 排列组合
 * @link <a href="https://www.lintcode.com/problem/1032">lintcode</a>
 */
public class LetterCasePermutation {

    /**
     * @param s: a string
     * @return return a list of strings
     * we will sort your return value in output
     */
    public static List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>(0);
        }

        List<String> res = new ArrayList<>();
        helper(s, 0, res);
        return res;
    }

    public static void helper(String s, int startIndex, List<String> res) {
        res.add(s);
        for (int i = startIndex; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                continue;
            }
            if (s.charAt(i) - 'a' >= 0) {
                //lowercase
                //can be turned to uppercase
                helper(s.substring(0, i) + (char) (s.charAt(i) - 'a' + 'A') + s.substring(i + 1), i + 1, res);
            } else {
                //uppercase
                //can be turned to lowercase
                helper(s.substring(0, i) + (char) (s.charAt(i) - 'A' + 'a') + s.substring(i + 1), i + 1, res);
            }
        }
    }
}