package org.newrain.code.problem.array;

import java.util.Arrays;

public class InterleavedArray {


    /**
     * @param a: the array A
     * @param b: the array B
     * @return: returns an alternate array of arrays A and B.
     */
    public static int[] interleavedArray1(int[] a, int[] b) {
        int res = a.length + b.length;
        int[] ans = new int[res];
        //奇数使用b数组，偶数用a数组
        int aPos = 0, bPos = 0;
        for (int i = 0; i < res; i++) {
            if (i % 2 == 0) {
                ans[i] = a[aPos];
                aPos++;
            } else {
                ans[i] = b[bPos];
                bPos++;
            }
        }
        return ans;
    }

    public static int[] interleavedArray2(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            ans[i * 2] = a[i];    //0 2 4 偶数位置取a数组
            ans[i * 2 + 1] = b[i];//1 3 5 奇数位置取b数组
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(interleavedArray2(new int[]{1, 2}, new int[]{3, 4})));
    }
}