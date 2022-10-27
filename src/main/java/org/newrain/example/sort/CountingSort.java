package org.newrain.example.sort;

import java.util.Arrays;

/**
 * @author newRain
 * @description 计数排序
 */
public class CountingSort {

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] countingSort(int max, int[] arr) {
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];
        //统计次数
        for (int k : arr) {
            bucket[k]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            //出现次数的
            while (bucket[j] > 0) {
                //数组开始排序 此处的j就代表了元素的值
                arr[sortedIndex++] = j;
                //次数-1
                bucket[j]--;
            }
        }
        return arr;
    }

    public static int[] sort(int[] array) {
        int max = getMax(array);
        return countingSort(max, array);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, 5, 9, 28, 19, 20})));
    }
}
