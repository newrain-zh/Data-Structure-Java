package org.newrain.code.problem.array;

import org.junit.Assert;

public class MissingNumber {

    /**
     * @param arr: the arithmetic progression array
     * @return: the missing number
     */
    public static int missingNumber(int[] arr) {
        //求出公差 最后一位减去首位除以数组长度
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + diff != arr[i + 1]) {
                return arr[i] + diff;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[]{2, 5, 8, 14}));
//        System.out.println(missingNumber(new int[]{1, 2, 4, 5}));
//        System.out.println(missingNumber(new int[]{5, 0, -10, -15}));
//        System.out.println(missingNumber(new int[]{10, 8, 7}));
        Assert.assertEquals(missingNumber(new int[]{-3, -11, -15, -19, -23}), -7);
    }
}