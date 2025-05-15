package org.newrain.problems.problem.string;


/**
 * 1945. 字符串转化后的各位数字之和
 *
 * @author NewRain
 */
public class LeetCode1945 {


    /**
     * 常规解法
     * 还有优化空间
     */
    public static int getLucky(String s, int k) {
        // 先转化
        StringBuilder str = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int index = c - 'a';
            str.append(index + 1);
        }
        int count = 0;
        String string = str.toString();
        System.out.println(string);
        int res = 0;
        while (count < k) {
            res = 0;
            int length = string.length();
            char[] charArray1 = string.toCharArray();
            for (int i = 0; i < length; i++) {
                res += charArray1[i] - '0';
            }
            string = String.valueOf(res);
            count++;
            if (string.length() == 1) {
                return res;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(getLucky("zbax", 2));
    }

}