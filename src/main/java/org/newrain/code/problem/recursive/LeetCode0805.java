package org.newrain.code.problem.recursive;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/recursive-mulitply-lcci/">...</a>
 */
public class LeetCode0805 {


    /**
     * a为偶数时 a × b = (a/2 × 2) × b = (a/2 × b) × 2
     * a/2 转化为 a>>1 右移
     * a*2 化为 a<<1 左移
     * a为奇数时  a × b = (a/2 × 2 + 1) × b = (a/2 × b) × 2 + b
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        if (A > B) {
            return multiply(B, A);
        }
        if (A == 0) {
            return 0;
        }
        System.out.println("a=" + (A >> 1) + "," + B);
        int half = multiply(A >> 1, B); // a/2 ,b
        if ((A & 1) == 0) { //偶数情况
            return half << 1; // 结果*2
        }
        return half << 1 + B;  // 结果*2 +1
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
//        System.out.println((a / 2 * b) * 2 + b);
        System.out.println(new LeetCode0805().multiply(a, b));


    }
}