package org.newrain.example.hash.mapexample;

/**
 * @author newRain
 * @description 2的次幂
 */
public class HashExample1 {

    public static void main(String[] args) {

        // 假设数组长度为不为2的幂次方
        int key = 0b1010; // 10
        int len = 0b10000; // 16
        System.out.println(key | len); // 26
        // key值产生了变化 会发现数组下标没有改变
        key = 0b1000;
        System.out.println(key | len); // 24
        System.out.println("=============");


        //扩容后位置无发生变化 这样减少扩容时候元素的位置计算
        key = 0b1010; // 10
        len = 0b10000; // 16
        //扩容的长度
        int len1 = 0b100000; //32
        System.out.println(10 % 16);  //26
        System.out.println(10 | 16);  //26
        System.out.println(10 | 32); //42
        System.out.println(Integer.toBinaryString(26));


    }
}
