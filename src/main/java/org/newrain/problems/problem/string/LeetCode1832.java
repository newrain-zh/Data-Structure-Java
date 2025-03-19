package org.newrain.problems.problem.string;

/**
 * 1832. 判断句子是否为全字母句
 */
public class LeetCode1832 {


    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        int[] arr = new int[26];
        char[] charArray = sentence.toCharArray();
        for (char c : charArray) {
            arr[c - 'a']++;
        }
        for (int j : arr) {
            if (j == 0) {
                return false;
            }
        }
        return true;

    }

}