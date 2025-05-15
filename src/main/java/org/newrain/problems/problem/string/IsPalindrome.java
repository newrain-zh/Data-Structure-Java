package org.newrain.problems.problem.string;

/**
 *
 * 题目：leetcode.125 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
 * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author newrain
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(c);
            }
        }
        String s3 = stringBuilder.toString();
        int length = s3.length();
        if (length == 0) {
            return true;
        }
        //这里做截取处理 然后通过StringBuilder api 方式来做比对
        int pos = length % 2 == 0 ? length / 2 : length / 2 + 1;
        String s1 = s3.substring(0, length / 2);
        String s2 = s3.substring(pos);
        return s1.contentEquals(new StringBuilder(s2).reverse());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        String testStr = "abbcbba";
        int pos = testStr.length() / 2;
        System.out.println(testStr.length() / 2);
        System.out.println(testStr.substring(0, pos));
        System.out.println(testStr.substring(pos + 1));
    }
}