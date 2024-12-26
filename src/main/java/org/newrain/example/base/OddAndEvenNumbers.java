package org.newrain.example.base;

public class OddAndEvenNumbers {

    public static void main(String[] args) {
    /*    System.out.println(isEvenNumber(2));
        System.out.println(isEvenNumber(1));
        System.out.println(isEvenNumber(-1));
        System.out.println(isEvenNumber(-2));
        System.out.println(isEvenNumber(-3));
        System.out.println(isEvenNumber(-4));
        System.out.println(isEvenNumber(-5));*/
        System.out.println(isEvenNumber1(-3));
        System.out.println(isEvenNumber1(-4));
        System.out.println(isEvenNumber1(-7));
        System.out.println(isEvenNumber1(-6));
        System.out.println(isEvenNumber1(-1));
        System.out.println(remainder(2, -1));
        System.out.println(-3 % 2);
    }

    /**
     * 用奇数判断是否偶数情况
     *
     * @param n
     * @return
     */
    public static String isEvenNumber(int n) {
        return n + "->" + (n % 2 != 0 ? "奇数" : "偶数");
    }

    public static String isEvenNumber1(int n) {
        return n + "->" + (n % 2 == 1 ? "奇数" : "偶数");
    }

    /**
     * 模拟取余计算
     *
     * @param dividend 被除数 2
     * @param divisor  除数 -1
     * @return
     */
    public static int remainder(int dividend, int divisor) {
        //被除数-被除数/除数*除数
        //2-2/-1*-1
        return dividend - dividend / divisor * divisor;
    }


}