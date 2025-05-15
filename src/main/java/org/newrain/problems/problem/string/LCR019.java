package org.newrain.problems.problem.string;

/**
 * LCR 019. 验证回文串 II
 *
 */
public class LCR019 {

    public static boolean validPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (charArray[l] != charArray[r]) {
                return isPalindrome(charArray, l + 1, r) || isPalindrome(charArray, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean validPalindrome1(String s) {
        char[] charArray = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r && charArray[l] == charArray[r]) {
            l++;
            r--;
        }
        return l >= r || isPalindrome(charArray, l + 1, r) || isPalindrome(charArray, l, r - 1);
    }

    public static void main(String[] args) {
//        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("cbccbc"));
        int l = 0, r = 5;
        while (l < r) {
            System.out.println("before=" + l + ":" + r);
            l++;
            r--;
            System.out.println("after=" + l + ":" + r);
        }
//        System.out.println(l + ":" + r);
    }

    public static boolean isPalindrome(char[] charArray, int l, int r) {
        while (l < r) {
            if (charArray[l] == charArray[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

}