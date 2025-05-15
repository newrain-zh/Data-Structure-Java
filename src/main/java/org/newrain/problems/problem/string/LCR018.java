package org.newrain.problems.problem.string;

/**
 * LCR 018. 验证回文串
 * <a href="https://leetcode.cn/problems/XltzEq/">...</a>
 */
public class LCR018 {

    /**
     * 更好的解法是将下面的逻辑整合到一个循环中解决
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        String s1 = s.toLowerCase();
        char[] chars = s1.toCharArray();
        StringBuilder newSb = new StringBuilder();
        for (char aChar : chars) {
            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= '0' && aChar <= '9')) {
                newSb.append(aChar);
            }
        }
        // 判断 newSb是否是回文
        String string = newSb.toString();
        char[] charArray = string.toCharArray();
        int l = 0, r = string.length() - 1;
        int len = string.length() / 2;
        for (int i = 0; i < len; i++) {
            if (charArray[l] == charArray[r]) {
//                System.out.println("l=" + l + ",r=" + r);
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
        System.out.println(9 / 2);
        // ra cea ac ar
    }
}