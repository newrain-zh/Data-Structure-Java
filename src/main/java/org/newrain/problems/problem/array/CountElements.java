package org.newrain.problems.problem.array;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class CountElements {


    /**
     * @param arr: the array
     * @return: the count of valid elements
     */
    public static int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length);
        for (int j : arr) {
            set.add(j);
        }
        int count = 0;
        for (int a : arr) {
            if (set.contains(a + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Assert.assertEquals(countElements(new int[]{1, 1, 2, 3}), 3);
    }

}