package org.newrain.problems.problem.search;

/**
 * leetcode.1047 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 输入："abbaca"
 * <p>
 * 输出："ca"
 * <p>
 * 解释：
 * <p>
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，
 * <p>
 * 这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
 * <p>
 * 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class RemoveDuplicates {


    /**
     * 利用栈的特性解决该题
     * 将当前字符压栈
     * 如果后面字符与栈顶的元素相等则进行“抵消”操作
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder stack = new StringBuilder();
        int top = -1;//对应要比较字符的指针
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (top >= 0 && curr == stack.charAt(top)) {
                stack.deleteCharAt(top);
                top--;
            } else {
                top++;
                stack.append(curr);
            }
        }
        return stack.toString();

    }
}