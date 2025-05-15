package org.newrain.problems.problem.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 1796. 字符串中第二大的数字
 */
public class LeetCode1796 {

    public static int secondHighest(String s) {
        if (s.isEmpty()) {
            return -1;
        }
        int max = -1, second = -1;
        char[] charArray = s.toCharArray();
        Set<Integer> set = new HashSet<>(10);
        for (char c : charArray) {
            if (c >= '0' && c <= '9') { //为数字
                int currNum = c - '0';
                set.add(currNum);
                if (currNum > max) {
                    second = max;
                    max = currNum;
                } else if (currNum > second && currNum != max) {
                    second = currNum;
                }
            }
        }
        if (set.size() == 1) {
            return -1;
        }
        return second;
    }

    public int secondHighest1(String s) {
        int max = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int tmp = c - '0';
                if (tmp > max) {
                    second = max;
                    max = tmp;
                } else if (tmp < max && tmp > second) {
                    second = tmp;
                }
            }
        }
        return second;
    }

    public int secondHighest2(String s) {

        int count = 2;
        for (char c = '9'; c >= '0'; c--) {
            if (s.indexOf(c) >= 0 && --count == 0) return c - '0';
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(secondHighest("dfa12321afd"));
//        System.out.println(secondHighest("abc1111"));
        System.out.println(secondHighest("ck077"));
    }
}