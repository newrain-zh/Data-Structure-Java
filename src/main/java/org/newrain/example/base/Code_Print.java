package org.newrain.example.base;


/**
 * 位运算基础
 */
public class Code_Print {

    /**
     * 打印一个int范围的数字的二进制数
     *
     * @param num
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(-83928328);
    }

}