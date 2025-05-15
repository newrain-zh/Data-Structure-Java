package org.newrain.problems.problem.string;

/**
 * @author NewRain
 * @description 反转字符串 II
 * @link <a href="https://leetcode.cn/problems/reverse-string-ii/"></a>
 */
public class LeetCode541 {

    public static String reverseStr(String s, int k) {
        //特殊情况
        if (k == 0) {
            return s;
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}