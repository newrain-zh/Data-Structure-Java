package org.newrain.code.problem.string;

/**
 * @author NewRain
 * @description 两字符串和
 * @link <a href="https://www.lintcode.com/problem/1343">lintcode</a>
 * @tag 字符串 String
 */
public class SumofTwoStrings {


    /**
     * @param a: a string
     * @param b: a string
     * @return return the sum of two strings
     */
    public static String sumofTwoStrings(String a, String b) {
        char[] chars = a.toCharArray(), chars1 = b.toCharArray();
        int minLen = Math.min(chars1.length, chars.length);
        int[] arr = new int[minLen];
        for (int i = 0; i < minLen; i++) {
            //获取最后一位
            int c = Character.getNumericValue(a.charAt(a.length() - 1 - i)) + Character.getNumericValue(b.charAt(b.length() - i - 1));
            arr[i] = c;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
        }
        String res = stringBuilder.toString();
        if (a.length() > minLen) {
            res = a.substring(0, a.length() - minLen) + res;
        }
        if (b.length() > minLen) {
            res = b.substring(0, b.length() - minLen) + res;
        }
        return res;
    }

    /**
     * @param a: a string
     * @param b: a string
     * @return return the sum of two strings
     * @see sumofTwoStrings
     */
    public static String sumofTwoStrings1(String a, String b) {
        char[] charsA = a.toCharArray(), charsB = b.toCharArray();
        //获取最长的字符的长度
        int maxLen = Math.max(charsB.length, charsA.length);
        //用数组保存每一个对应字符相加的值
        int[] arr = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            //获取最后一位
            //从后向前取值 超出数组长度表示 当前字符串数组的长度已经用尽 用0替换值
            int aNumber = a.length() - 1 - i < 0 ? 0 : Character.getNumericValue(a.charAt(a.length() - 1 - i));
            int bNumber = b.length() - 1 - i < 0 ? 0 : Character.getNumericValue(b.charAt(b.length() - 1 - i));
            arr[i] = aNumber + bNumber;

        }
        StringBuilder stringBuilder = new StringBuilder();
        //数组的值倒序取出
        for (int i = arr.length - 1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        //9910
//        System.out.println(sumofTwoStrings("999", "1"));
//        11010
//        System.out.println(sumofTwoStrings("99", "111"));
        //1121013
        System.out.println(sumofTwoStrings("999", "1314"));
    }


}