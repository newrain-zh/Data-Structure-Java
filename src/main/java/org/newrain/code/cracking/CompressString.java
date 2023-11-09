package org.newrain.code.cracking;

/**
 * 字符串压缩。利用字符重复出现的次数，
 * 编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * @author newrain
 * @description 字符串压缩
 * @link <a href="https://leetcode.cn/problems/compress-string-lcci"></a>
 */
public class CompressString {


    public static String compressString(String str) {
        //特殊情况
        if (str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        //开始指针
        int start = 0, length = chars.length;
        while (start < length) {
            int p = start + 1;
            int count = 1;
            //从左到右开始比对找到所有相连的不重复元素
            while (p < length && chars[start] == chars[p]) {
                p++;
                count++;
            }
            stringBuilder.append(chars[start]).append(count);
            //从下一个不重复的位置开始
            start = p;
        }
        String compressString = stringBuilder.toString();
        return compressString.length() >= str.length() ? str : compressString;
    }

    public static void main(String[] args) {
        //a2b1c5a3
        System.out.println(compressString("aabcccccaaa"));
        //a1b2c2d1
        System.out.println(compressString("abbccd"));
    }
}