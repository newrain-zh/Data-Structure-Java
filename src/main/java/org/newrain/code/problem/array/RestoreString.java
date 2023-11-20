package org.newrain.code.problem.array;

/**
 * 重新排列字符串
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * 返回重新排列后的字符串。
 */
public class RestoreString {


    public static String restoreString(String s, int[] indices) {
        int length = indices.length;
        char[] ans = new char[length];
        for (int i = 0; i < length; i++) {
            ans[indices[i]] = s.charAt(i);// i=0时 ans[4] = s.charAt(0)
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }

}