package org.newrain.code.problem.array;

public class CountOnes {

    /**
     * @param num: An integer
     * @return: An integer, the number of ones in num
     */
    public int countOnes(int num) {
        String binaryString = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if ('1' == binaryString.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用位运算
     *
     * @param n
     * @return
     */
    public static int countOnes1(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(countOnes1(5));
        System.out.println(Integer.bitCount(5));//api方式
    }
}