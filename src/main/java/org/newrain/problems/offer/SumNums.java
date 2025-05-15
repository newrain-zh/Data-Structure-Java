package org.newrain.problems.offer;

public class SumNums {

    static int res = 0;

    public static int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(2));
    }

}