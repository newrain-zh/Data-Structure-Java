package org.newrain.problems.problem.array;

import java.util.HashSet;
import java.util.Set;


/**
 * LeetCode.575 分糖果
 */
public class LeetCode575 {


    public int distributeCandies(int[] candyType) {
        int max = candyType.length / 2;
        Set<Integer> dict = new HashSet<>();
        for (int j : candyType) {
            dict.add(j);
        }
        return Math.min(dict.size(), max);
    }
}