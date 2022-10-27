package org.newrain.example.structure.list;

import java.util.Arrays;

/**
 * @author newRain
 * @description 动态数组实现
 */
public class MyList {
    public int[] arr = new int[10];
    int size = 0;

    /**
     * 顺序添加元素
     *
     * @param v
     */
    public void add(int v) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = v;
                size++;
                break;
            }
        }
    }

    /**
     * 在指定位置插入元素
     *
     * @param v
     * @param index
     */
    public void insert(int v, int index) {
        //首先判断位置是否越界
        if (index > size) {
            throw new RuntimeException("访问数组下标越界");
        }
        //移位操作
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = v;
        size++;
    }

    public static void main(String[] args) {
        MyList myArray = new MyList();
        myArray.add(1);
        myArray.add(2);
        System.out.println(Arrays.toString(myArray.arr));
        myArray.insert(3, 0);
        myArray.insert(4, 1);
        System.out.println(Arrays.toString(myArray.arr));
    }

}
