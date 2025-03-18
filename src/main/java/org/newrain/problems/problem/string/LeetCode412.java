package org.newrain.problems.problem.string;

import java.util.ArrayList;
import java.util.List;


/**
 * 412. Fizz Buzz
 * <a href="https://leetcode.cn/problems/fizz-buzz/description/">...</a>
 */
public class LeetCode412 {
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

}