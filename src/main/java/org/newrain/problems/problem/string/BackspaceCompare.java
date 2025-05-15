package org.newrain.problems.problem.string;

/**
 * @author NewRain
 * @description 比较含退格的字符串
 * @link <a href="https://leetcode.cn/problems/backspace-string-compare/"><a/>
 * @link <a href="https://www.lintcode.com/problem/1425/">...</a>
 */
public class BackspaceCompare {


    public static boolean backspaceCompare(String s, String t) {
        String str1 = remove(s);
        String str2 = remove(t);
        return str1.equals(str2);
    }

    /**
     * 该解题思路为借用StringBuilder删除#和前面的字符
     * 最后比较字符串 也可以使用char数组来赋空字符串手动删除字符串比较
     *
     * @param str
     * @return
     */
    public static String remove(String str) {
        if (!str.contains("#")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.indexOf("#") >= 0) {
            int index = stringBuilder.indexOf("#");
            if (index == 0) {
                stringBuilder.deleteCharAt(index);
            } else {
                stringBuilder.delete(index - 1, index + 1);
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab#c", "ad#c"));
//        System.out.println(backspaceCompare("a#c", "b"));
//        System.out.println(backspaceCompare("ab##", "c#d#"));
//        System.out.println(remove("ab##"));
//        System.out.println(remove("c#d#"));
        System.out.println(remove("a##c"));
        System.out.println(remove("#a#c"));
//        StringBuilder stringBuilder = new StringBuilder("ab##");
//        stringBuilder.delete(1, 3);
//        System.out.println(stringBuilder);
    }
}