package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目: 查找常用字符
 * 给你一个字符串数组 words ，
 * 请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），
 * 并以数组形式返回。你可以按 任意顺序 返回答案。
 */
public class CommonChars {

    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));//[e,l,l]
        System.out.println(commonChars(new String[]{"cool", "lock", "cook"}));//[c,o]
       /* String str2 = "cool";
        String str1 = "lock"; //

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        for (int i = 0; i < charArray1.length; i++) {
            for (int j = 0; j < charArray2.length; j++) {
                if (charArray2[j] >= 'a' && charArray2[j] <= 'z') { //为小写
                    if (charArray1[i] == charArray2[j]) {
                        charArray2[j] ^= 32;
                        charArray1[i] ^= 32;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(charArray1));*/


    }

    public static List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        List<char[]> list = new ArrayList<>(words.length);
        for (String word : words) {
            char[] charArray = word.toCharArray();
            list.add(charArray);
        }
        char[] common = null;
        for (char[] chars : list) {
            common = getCommon(common, chars);
        }
        if (common == null) return new ArrayList<>(0);
        for (char c : common) {
            ans.add(String.valueOf(c));
        }
        return ans;
    }

    /**
     * 采用消除法 将两个数组的字符串变成大写
     * @param charArray1
     * @param charArray2
     * @return
     */
    public static char[] getCommon(char[] charArray1, char[] charArray2) {
        if (charArray1 == null) {
            return charArray2;
        }
        for (int i = 0; i < charArray1.length; i++) {
            for (int j = 0; j < charArray2.length; j++) {
                if (charArray2[j] >= 'a' && charArray2[j] <= 'z') { //为小写
                    if (charArray1[i] == charArray2[j]) {
                        charArray2[j] ^= 32;
                        charArray1[i] ^= 32;
                    }
                }
            }
        }
        List<Character> list = new ArrayList<>();
        for (char c : charArray1) {
            if (c >= 'A' && c <= 'Z') {
                c |= 32;
                list.add(c);
            }
        }
        char[] ans = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}