package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode.412 Fizz Buzz
 */
public class FizzBuzz {


    /**
     * @param n: An integer
     * @return A list of strings.
     */
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("fizz buzz");
                continue;
            }
            if (i % 3 == 0) {
                res.add("fizz");
                continue;
            }
            if (i % 5 == 0) {
                res.add("buzz");
                continue;
            }
            res.add(i + "");

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

}