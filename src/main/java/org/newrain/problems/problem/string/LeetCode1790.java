package org.newrain.problems.problem.string;


/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 */
public class LeetCode1790 {


    /**
     * 字符出现次数一致，顺序大部分一致
     */
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        int length = s1.length(), countDiff = 0;
        int[] diffIndex = new int[3];
        for (int i = 0; i < length; i++) {
            if (charArray1[i] != charArray2[i]) {
                countDiff++;
                if (countDiff > 2) {
                    return false;
                }
                diffIndex[countDiff] = i;
            }
        }
        // 交换位置
        // "bank", "kanb" 不同位置索引
        //  0 3 bank -> [0 b] [3 k] s1
        //  0 3 kanb -> [0 k] [3 b] s2
        return s1.charAt(diffIndex[1]) == s2.charAt(diffIndex[2]) && s1.charAt(diffIndex[2]) == s2.charAt(diffIndex[1]);
    }

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb")); // 0 3
        System.out.println(areAlmostEqual("abcd", "dcba"));
    }
}