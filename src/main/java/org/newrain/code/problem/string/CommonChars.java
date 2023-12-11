package org.newrain.code.problem.string;

import java.util.Collections;
import java.util.List;

/**
 * leetcode.1002 查找公用字符串
 * @author NewRain
 */
public class CommonChars {

    public static List<String> commonChars(String[] words) {
        if (words.length == 1) {
            return Collections.emptyList();
        }
        //先找出最短的那个字符串
        int minLen = words[0].length(), pos = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < minLen) {
                pos = i;
                minLen = words[i].length();
            }
        }
        String dictStr = words[pos];
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            int subIndex = 0;
            StringBuilder currDict = new StringBuilder();
            if (i != pos) {
                while (subIndex < curr.length() - 1) {
                    subIndex++;
                }
                dictStr = currDict.toString();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));
    }
}