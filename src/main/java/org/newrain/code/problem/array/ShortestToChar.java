package org.newrain.code.problem.array;

import java.util.Arrays;

/**
 *
 * leetcode.821 字符的最短距离
 * @author NewRain
 * @description 字符的最短距离
 * @link <a href="https://leetcode.cn/problems/shortest-distance-to-a-character/"></a>
 */
public class ShortestToChar {

    public static int[] shortestToChar(String s, char c) {
        int[] arr = new int[s.length()];
        char[] chars = s.toCharArray();
        //index为c字符下标
        int length = chars.length, count = 0, index = -1;
        //先从左到右
        for (int i = 0; i < length; i++) {
            if (chars[i] == c) {
                //更新下标
                index = i;
                arr[i] = 0;
                count++;
            } else if (index != -1) {
                arr[i] = i - index;
            } else {
                arr[i] = length + 1;
            }
        }
        //如果只出现一次
        if (count == 1) {
            for (int i = 0; i < length; i++) {
                if (i == index) {
                    arr[i] = 0;
                } else {
                    arr[i] = Math.abs(i - index);
                }

            }
            return arr;
        }
        //从右向左
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == c) {
                arr[i] = 0;
                index = i;
            } else if (index != -1) {
                arr[i] = Math.min(arr[i], Math.abs(i - index));
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }
}