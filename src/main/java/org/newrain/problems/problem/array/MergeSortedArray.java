package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * leetcode.6 合并排序数组
 * @author NewRain
 * @description 合并排序数组
 * @tag 双指针
 * @link <a href="https://www.lintcode.com/problem/6">lintcode</a>
 */
public class MergeSortedArray {

    /**
     * 使用额外的空间的计算方法
     * 优点是简单易于理解
     *
     * @param a: sorted integer array A
     * @param b: sorted integer array B
     * @return A new sorted integer array
     */
    public int[] mergeSortedArray(int[] a, int[] b) {
        int len = a.length + b.length;
        List<Integer> res = new ArrayList<>(len);
        for (int k : a) {
            res.add(k);
        }
        for (int j : b) {
            res.add(j);
        }
        Collections.sort(res);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    /**
     * 双指针解法
     *
     * @param a: sorted integer array A
     * @param b: sorted integer array B
     * @return A new sorted integer array
     */
    public static int[] mergeSortedArray1(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        //i,j为两个数组的遍历的指针 index为最后遍历的位置
        int i = 0, j = 0, index = 0;
        //遍历两个数组 比较大小 其中一个数值较小的 肯定是能遍历结束的
        while (i <= a.length - 1 && j <= b.length - 1) {
            if (a[i] <= b[j]) {
                res[index++] = a[i++];
            } else {
                res[index++] = b[j++];
            }
        }
        //最后将没有遍历的数组追加到数组的末尾
        while (i <= a.length - 1) {
            res[index++] = a[i++];
        }
        while (j <= b.length - 1) {
            res[index++] = b[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = mergeSortedArray1(new int[]{1}, new int[]{1});
        System.out.println(Arrays.toString(ints));

    }

}