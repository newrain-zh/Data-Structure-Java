package org.newrain.code.cracking;

/**
 * @author NewRain
 * @description 最大的值
 */
public class Maximum {

    public static int maximum(int a, int b) {
        //a>b,那么 a+b+a-b=2a
        //a<b,那么a+b+b-a=2b
        long c = a, d = b;
        long f = (c + d + Math.abs(c - d)) / 2L;
        return (int) f;
    }

    public static void main(String[] args) {
        System.out.println(maximum(1, 2));
    }
}