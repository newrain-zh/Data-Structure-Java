package org.newrain.problems.problem.array;


/**
 * LeetCode.4 寻找两个正序数组的中位数
 */
public class LeetCode4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
       /* if (len == 1) {
            if (nums1.length == 1) {
                return nums1[0];
            } else {
                return nums2[0];
            }
        }*/
        int[] arr = new int[2];
        int   l   = 0, r = 0, mid = len / 2;
        for (int i = 0; i < len; i++) {
            int n1 = l < nums1.length ? nums1[l] : Integer.MAX_VALUE;
            int n2 = r < nums2.length ? nums2[r] : Integer.MAX_VALUE;
            int val;
            if (n1 <= n2) {
                val = nums1[l];
                l++;
            } else {
                val = nums2[r];
                r++;
            }
            if (i == mid || i == mid - 1) {
                int index = i == mid - 1 ? 0 : 1;
                arr[index] = val;
            }
            if (i > mid) {
                break;
            }
        }
        if (len % 2 == 0) {
            return (double) (arr[0] + arr[1]) / 2;
        }
        return arr[1];
    }


    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len == 1) {
            if (nums1.length == 1) {
                return nums1[0];
            } else {
                return nums2[0];
            }
        }
        int   l   = 0, r = 0, mid = len / 2;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int n1 = l < nums1.length ? nums1[l] : Integer.MAX_VALUE;
            int n2 = r < nums2.length ? nums2[r] : Integer.MAX_VALUE;
            if (n1 <= n2) {
                arr[i] = nums1[l];
                l++;
            } else {
                arr[i] = nums2[r];
                r++;
            }
            if (i > mid) {
                break;
            }

        }
        if (len % 2 == 0) {
            return (double) (arr[mid - 1] + arr[mid]) / 2;
        } else {
            return arr[mid];
        }
    }


    public static void main(String[] args) {
        System.out.println("test:" + findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // 2.5
        System.out.println("test:" + findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2
        System.out.println("test:" + findMedianSortedArrays(new int[]{}, new int[]{1})); // 1
        System.out.println("test:" + findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3})); // 2
        System.out.println("test:" + findMedianSortedArrays(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1})); // 2

    }

}