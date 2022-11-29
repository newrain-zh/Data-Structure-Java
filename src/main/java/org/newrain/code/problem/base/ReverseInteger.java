package org.newrain.code.problem.base;

/**
 * @author NewRain
 * @description 整数反转 反转一个三位整数
 * @link <a href="https://www.lintcode.com/problem/37">lintcode</a>
 * @link <a href="https://leetcode.cn/problems/reverse-integer/submissions/">leetcode</a>
 */
public class ReverseInteger {

    public int reverseInteger(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static int reverseIntegerByString(int number) {
        StringBuilder reverse = new StringBuilder(number + "").reverse();
        if (reverse.indexOf("-") >= 0) {
            reverse.deleteCharAt(reverse.indexOf("-"));
        }
        long res;
        if (number < 0) {
            res = Long.parseLong("-" + reverse);
        } else {
            res = Long.parseLong(reverse.toString());
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {

        System.out.println(reverseIntegerByString(-2147483648));
    }

}
