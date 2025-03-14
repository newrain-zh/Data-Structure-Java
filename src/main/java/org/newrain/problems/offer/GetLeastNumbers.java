package org.newrain.problems.offer;

import java.util.Arrays;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return arr;
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}