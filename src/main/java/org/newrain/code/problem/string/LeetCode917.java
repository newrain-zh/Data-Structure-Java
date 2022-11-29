package org.newrain.code.problem.string;

import java.util.*;

/**
 * @author NewRain
 * @description
 * @link
 */
public class LeetCode917 {

    public static String reverseOnlyLetters(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> listIndex = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                stringBuilder.append(s.charAt(i));
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                stringBuilder.append(s.charAt(i));
            } else {
                count++;
                listIndex.add(i);
            }
        }
        //没有特殊字符
        if (count == 0) {
            return new StringBuilder(s).reverse().toString();
        }
        StringBuilder reverse = stringBuilder.reverse();
        for (int offset : listIndex) {
            String ch = String.valueOf(s.charAt(offset));
            reverse.insert(offset, ch);
        }
        return reverse.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!").equals("Qedo1ct-eeLg=ntse-T!"));
    }
}
