package org.newrain.problems.problem.stack;

/**
 * 1021. 删除最外层的括号
 * <a href="https://leetcode.cn/problems/remove-outermost-parentheses/">...</a>
 */
public class LeetCode1021 {


    public static String removeOuterParentheses(String s) {
        char[] charArray = s.toCharArray();
        int blance = 0, start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                blance++;
            } else {
                blance--;
            }
            if (blance == 0) {
                sb.append(s, start + 1, i);
                start = i + 1;
            }
        }
        return sb.toString();
    }

    /**
     * 更优秀的解法
     *
     * @param s
     * @return
     */
    public String removeOuterParentheses1(String s) {

        char[] cs = s.toCharArray();
        int n = cs.length;
        int top = -1;

        char[] result = new char[n];
        int index = 0;

        for (char c : cs) {

            if (c == ')') top--;

            if (top != -1) result[index++] = c;

            if (c == '(') top++;
        }

        return new String(result, 0, index);

    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}