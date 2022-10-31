package org.newrain.leetcode.problem.number;

public class LeetCode258 {


    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        String s = Integer.toString(num);
        int count = count(s);
        while (count >= 10) {
            count = count(Integer.toString(count));
        }
        return count;
    }

    private static int count(String s) {
        char[] chars = s.toCharArray();
        int r = 0;
        for (char c : chars) {
            r = r + Integer.parseInt(c + "");
        }
        return r;
    }


    public static int addDigits1(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        // return (num - 1) % 9 + 1;
        return num;
    }


    private static int count1(int num, int len) {
        int carry = 1;
        for (int i = 0; i < len; i++) {
            carry = carry * 10;
        }
        return num / carry;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(19));
        System.out.println(addDigits(12345678));

    }
}
