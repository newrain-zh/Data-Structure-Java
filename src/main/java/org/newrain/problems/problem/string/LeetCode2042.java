package org.newrain.problems.problem.string;

/**
 * LeetCode 2042. 检查句子中的数字是否递增
 *
 * @author NewRain
 * <a href="https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/">...</a>
 */
public class LeetCode2042 {


    public static boolean areNumbersAscending(String s) {
        int perv = -1;
        String[] s1 = s.split(" ");
        for (String string : s1) {
            if (!isDigit(string)) { // 如果不是字符 直接略过
                continue;
            }
            int currentNum = Integer.parseInt(string);
            if (currentNum > perv) {
                perv = currentNum;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isDigit(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println();
        System.out.println(areNumbersAscending("hello world 5 x 5"));
    }
}