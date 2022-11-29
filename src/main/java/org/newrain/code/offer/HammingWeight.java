package org.newrain.code.offer;

public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(count(18));
        System.out.println(count(16));
        //api方法
        System.out.println(Integer.bitCount(18));
    }

    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
     */
    public static int count(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & n - 1;
        }
        return count;
    }
}
