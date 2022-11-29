package org.newrain.example.hash.mapexample;

/**
 * @author NewRain
 * @description hash结构length的设置
 */
public class LengthExample {
    public static void main(String[] args) {
        // 这里length 你可以更改为2的次方进行调试
        int length = 16;
        int hashCode = 4;
        int h = hashCode % length;
        int hash = hashCode & (length - 1);
        System.out.println("取模运算：" + h);
        System.out.println("&运算：" + hash);
        //4 & 15 = 4
        System.out.println("100&1111=" + Integer.toBinaryString(4 & 15));
    }
}
