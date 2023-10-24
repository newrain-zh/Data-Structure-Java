package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 三个有序数组的交集
 */
public class ArraysIntersection {

    /**
     * @param arr1:
     * @param arr2:
     * @param arr3:
     * @return: The intersection of three arrays
     */
    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        if (arr1.length == 0 || arr2.length == 0 || arr3.length == 0) {
            return new ArrayList<>(0);
        }
        List<Integer> set = new ArrayList<>(arr1.length);
        for (int j : arr1) {
            set.add(j);
        }
        List<Integer> all = new ArrayList<>(arr1.length);//all arr1和arr2的交集
        for (int j : arr2) {
            if (set.contains(j)) {
                all.add(j);
            }
        }
        if (all.isEmpty()) {
            return new ArrayList<>(0);
        }
        List<Integer> last = new ArrayList<>();
        for (int j : arr3) {
            if (all.contains(j)) {
                last.add(j);
            }
        }
        return last;
    }

    public static void main(String[] args) {
        List<Integer> integers = arraysIntersection(new int[]{1, 2, 3}, new int[]{2, 3, 4}, new int[]{3, 4, 5});
        System.out.println(integers.toString());
    }
}