package org.newrain.problems.problem.string;

/**
 * leetcode.415 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings {

    /**
     * 字符串不期后进行相加
     * 还有更优的解法 同时遍历两个集合进行数字上的相加减
     * <p>
     * 提示如下
     * int x = num1.charAt(i)-48 这样的方式来获取char转成的数字
     * 获取个位数 sum%10
     * 获取进位 sum/10
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        //先将长度补到等同
        int max = Math.max(num1.length(), num2.length());
        int minL = Math.min(num1.length(), num2.length());
        if (num1.length() != max) {
            num1 = zero(num1, max - minL);
        }
        if (num2.length() != max) {
            num2 = zero(num2, max - minL);
        }
        int curry = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            int c1 = Character.digit(num1.charAt(i), 10);
            int c2 = Character.digit(num2.charAt(i), 10);
            if (c1 + c2 + curry >= 10) {
                ans.append((c1 + c2 + curry) % 10);
                curry = 1;
            } else {
                ans.append(c1 + c2 + curry);
                curry = 0;
            }
        }
        if (curry == 1) {
            return ans.append("1").reverse().toString();
        }
        return ans.reverse().toString();
    }


    private static String zero(String num, int zeroCount) {
        if (zeroCount == 0) {
            return num;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < zeroCount; i++) {
            s.append("0");
        }
        num = s + num;
        return num;
    }

    //456
    //077
    //133
    public static void main(String[] args) {
        System.out.println(addStrings("111", "123"));//234
        System.out.println(addStrings("11", "123")); //134
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("999", "999"));
        char c = '9';
        int i = c - 48;
        System.out.println(i);
    }
}