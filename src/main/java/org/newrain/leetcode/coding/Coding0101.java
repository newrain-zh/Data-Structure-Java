package org.newrain.leetcode.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author newrain
 * @description 面试题 01.01. 判定字符是否唯一
 * @see <a href="https://leetcode.cn/problems/is-unique-lcci"></a>
 */
public class Coding0101 {


    public static boolean isUniqueBySet(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int length = str.length();
        if (length == 1) {
            return true;
        }
        Set<Character> set = new HashSet<>(length);
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static boolean isUnique(String str) {
        //为"" or null 情况
        if (str == null || str.length() == 0) {
            return true;
        }
        int length = str.length();
        //边界
        if (length > 26) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        char[] chars = str.toCharArray();
        //进行排序 如果重复 则相邻的元素会相等
        Arrays.sort(chars);
        int start = 0;
        while (start < str.length() - 1) {
            if (chars[start] == chars[start + 1]) {
                return false;
            }
            start++;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abccbccc"));
    }


}
