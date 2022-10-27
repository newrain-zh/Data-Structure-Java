package org.newrain.leetcode.offer;

public class ReverseWords {

    public static String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if ("".equals(strs[i])) {
                continue; // 遇到空单词则跳过
            }
            res.append(strs[i]).append(" "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
