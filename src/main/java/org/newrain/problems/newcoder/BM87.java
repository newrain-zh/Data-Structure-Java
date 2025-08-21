package org.newrain.problems.newcoder;

import java.util.Arrays;

public class BM87 {


    public static void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];  // A的当前元素更大，放入合并位置
            } else {
                A[k--] = B[j--];  // B的当前元素更大，放入合并位置
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }

    }

    public static void merge1(int A[], int m, int B[], int n) {
        int[] C = new int[m + n];
        System.arraycopy(A, 0, C, 0, m);
        int p1 = 0, p2 = 0, step = 0;
        while (p1 < m && p2 < n) { // 结束条件为其中一个数组的元素用尽
            if (C[p1] > B[p2]) {
                A[step] = B[p2];
                p2++;
            } else {
                A[step] = C[p1];
                p1++;
            }
            step++;
        }
        while (p2 < n) { // B数组还有剩余元素
            A[step++] = B[p2++];
        }
        while (p1 < m) { // A数组还有剩余元素
            A[step++] = C[p1++];
        }

    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 0, 0, 0};
        int[] B = {1, 2, 3};
        merge1(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }
}