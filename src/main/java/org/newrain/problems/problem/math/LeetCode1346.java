package org.newrain.problems.problem.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 1346. 检查整数及其两倍数是否存在
 */
public class LeetCode1346 {

    public static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> dict = new HashMap<>(arr.length);
        int countZero = 0;
        for (int j : arr) {
            if (j == 0) {
                countZero++;
            }else {
                dict.put(j * 2, j);
            }
        }
        if (countZero >= 2) {
            return true;
        }
        for (int N : arr) {
            if (dict.get(N) != null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));
//        System.out.println(checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }
}