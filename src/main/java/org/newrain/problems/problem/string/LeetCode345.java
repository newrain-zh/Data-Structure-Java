package org.newrain.problems.problem.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * LeetCode.345 反转字符串中的元音字母
 */
public class LeetCode345 {


    public static String reverseVowels(String s) {
        Set<Character> dict = new HashSet<Character>(10) {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        int l = 0, r = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (l < r) {
            while (l < r && !dict.contains(charArray[l])) {
                l++;
            }
            while (l < r && !dict.contains(charArray[r])) {
                r--;
            }
            if (l < r) {
                char temp = charArray[l];
                charArray[l] = charArray[r];
                charArray[r] = temp;
                l++;
                r--;
            }
        }
        return new String(charArray);
    }

    public static String reverseVowels1(String s) {
        Set<Character> dict = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (dict.contains(c)) {
                stack.push(c);
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if (dict.contains(charArray[i])) {
                charArray[i] = stack.pop();
            }
        }
        return new String(charArray);


    }


    public static void main(String[] args) {
        System.out.println(reverseVowels1("IceCreAm")); // AceCreIm
//        System.out.println(reverseVowels("leetcode")); // leotcede
//        System.out.println(reverseVowels("ai")); // ia
//        System.out.println(reverseVowels("Marge, let's \\\"went.\\\" I await news telegram.")); // ia
    }
}