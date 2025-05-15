package org.newrain.problems.problem.math;


/**
 * LeetCode.405  数字转换为十六进制数
 */
public class LeetCode405 {


    public static String toHex(int num) {
        if (num == 0) return "0";
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int digit = num & 0xf;  // 取最低四位
            sb.append(hexChars[digit]);
            num >>>= 4;  // 无符号右移四位
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
        System.out.println(Integer.toString(16, 2));
    }

}