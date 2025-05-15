package org.newrain.problems.problem.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NewRain
 * @description 最大字母
 * @link <a href="https://www.lintcode.com/problem/353">lintcode</a>
 */
public class LargestLetter {

    /**
     * @param s: a string
     * @return a string
     */
    public static String largestLetter(String s) {
        byte[] bytes = new byte[128];
        //记录所有字母次数
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            bytes[ch] += 1;
        }
        //倒序输出 最大的那个肯定在最后
        for (int i = bytes.length - 1; i > 0; i--) {
            if (bytes[i] >= 1 && bytes[i - 32] >= 1) {
                return String.valueOf((char) (i - 32));
            }
        }
        return "NO";
    }

    public static String largestLetter1(String s) {
        Map<Integer, Integer> map = new HashMap<>(s.length());
        //记录所有字母次数
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put((int) ch, map.getOrDefault((int) ch, 0) + 1);
        }
        int max = -1;
        for (Integer key : map.keySet()) {
            if (map.getOrDefault(key, 0) >= 1 && map.getOrDefault(key + 32, 0) >= 1) {
                max = Math.max(max, key);
            }
        }
        if (max == -1) {
            return "NO";
        }
        max &= -33;
        return String.valueOf((char) max);
    }

    public static void main(String[] args) {
        System.out.println(largestLetter1("giNjsjsbroWmIjJjJRCptJUFNSKzLkMURsocxfNulfhWJACWZmQEUTSkkSfDKJvFtOBzNEsBvXWuThVLhZdUbFTvAcxeRcAVGbVM"));
        System.out.println((int) 'A');
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'y');
        System.out.println((int) 'd');
        return;

    }
}