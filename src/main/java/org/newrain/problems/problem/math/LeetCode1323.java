package org.newrain.problems.problem.math;


/**
 * LeetCode.1323  6 和 9 组成的最大数字
 */
public class LeetCode1323 {


    public static int maximum69Number(int num) {
        String s = String.valueOf(num);
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == '6') {
                charArray[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(charArray));
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(9669 / 10); // 966
        System.out.println(966 / 10); // 96
        System.out.println(96 / 10); // 9
        System.out.println(9 / 10); // 9
    }

}