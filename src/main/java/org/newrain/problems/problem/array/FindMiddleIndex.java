package org.newrain.problems.problem.array;

public class FindMiddleIndex {

    public int findMiddleIndex(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 18));
    }

    public  static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}