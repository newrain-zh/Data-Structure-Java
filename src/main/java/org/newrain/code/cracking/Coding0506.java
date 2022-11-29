package org.newrain.code.cracking;

/**
 * @author NewRain
 * @link <a href="https://leetcode.cn/problems/convert-integer-lcci">leetcode</a>
 */
public class Coding0506 {

    public int convertInteger1(int a, int b) {
        //位异或
        int x = a ^ b, cnt = 0;
        while (x != 0) {
            //x和x-1位与可以消掉x最低位的1
            x &= (x - 1);
            cnt++;
        }
        return cnt;
    }

    public int convertInteger2(int a, int b) {
        return Integer.bitCount(a ^ b);
    }
}
