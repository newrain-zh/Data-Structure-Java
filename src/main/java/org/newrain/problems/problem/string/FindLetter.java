package org.newrain.problems.problem.string;

/**
 * 题目： lintcode.1820 寻找字母
 * @author NewRain
 * @description 寻找字母
 * @link <a href="https://www.lintcode.com/problem/1820">...lintcode</a>
 */
public class FindLetter {

    /**
     * @param str: the str
     * @return the letter
     */
    public static char findLetter(String str) {
        if (str == null || str.isEmpty()) {
            return '~';
        }
        int[] ints = new int[128];
        for (int i = 0; i < str.length(); i++) {
            ints[str.charAt(i)]++;
        }
        for (int i = ints.length - 1; i >= 65; i--) {
            if (ints[i] > 0 && ints[i - 32] > 0) {
                return (char) (i - 32);
            }
        }
        return '~';
    }

    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println(findLetter("aAbBcD"));
    }
}