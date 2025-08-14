package org.newrain.problems.problem.string;

public class Solve {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public static String solve(String str) {
        if (str == null || str.isEmpty()) return str;
        char[]        charArray = str.toCharArray();
        StringBuilder res       = new StringBuilder();
        int           len       = charArray.length;
        for (int i = len - 1; i >= 0; i--) {
            res.append(charArray[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("abcd"));

    }
}