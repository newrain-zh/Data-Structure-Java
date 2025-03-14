package org.newrain.problems.problem.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author NewRain
 * @description 字符删除
 * @link <a href="https://www.lintcode.com/problem/1905">lintcode</a>
 */
public class CharacterDeletion {


    /**
     * @param str: The first string given
     * @param sub: The given second string
     * @return Returns the deleted string
     */
    public static String characterDeletion(String str, String sub) {
        if (sub == null || sub.length() == 0 || str == null || str.length() == 0) {
            return str;
        }
        Set<Character> removeChar = new HashSet<>(sub.length());
        for (char c : sub.toCharArray()) {
            removeChar.add(c);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!removeChar.contains(str.charAt(i))) {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}