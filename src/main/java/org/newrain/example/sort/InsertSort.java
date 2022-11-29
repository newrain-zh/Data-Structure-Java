package org.newrain.example.sort;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 插入排序
 */
public class InsertSort {

    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //当前值
            int insetValue = array[i];
            int j = i;
            //查找待插入的位置
            while (j > 0 && insetValue < array[j - 1]) {
                //将前面的比insetValue大的值后移一位
                array[j] = array[j - 1];
                j--;
            }
            //如果指针移动过表示j是当前值该插入的位置
            if (j != i) {
                array[j] = insetValue;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertSort(new int[]{5, 3, 2, 1})));
    }
}
