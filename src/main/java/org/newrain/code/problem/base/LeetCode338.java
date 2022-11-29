package org.newrain.code.problem.base;

/**
 * @author NewRain
 */
public class LeetCode338 {


    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }

    public static int count(int x) {
        int cnt = 0;
        while (x > 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        count(11);
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(7));
    }

}
