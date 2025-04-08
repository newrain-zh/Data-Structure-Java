package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode. 有重复字符串的排列组合
 */
public class LeetCode0808 {

    private final List<String> ret = new ArrayList<>();


    public String[] permutation(String S) {
        char[] array = S.toCharArray();
        Arrays.sort(array);
        backtracking(array, new boolean[S.length()], new StringBuilder());
        String[] ans = new String[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }

    /*
            [ q, q , e ] |
             ↙           |
       [ q, q , e ]      |   [ q, q , e ]  [ q, q , e ]
           ↙             |       ↗                   ↘        ↱ used[2] = true
 [ q, q , e ]  ⮕ "qqe"  ｜   回溯                    [ q, q , e ] ⮕ "qeq"      开始回溯
                                                          ⭣
                                                          条件生效〖i > 0 && chars[i - 1] == chars[i] && !used[i - 1]〗
     */
    private void backtracking(char[] chars, boolean[] used, StringBuilder path) {
        if (path.length() == chars.length) {
            ret.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i - 1] == chars[i] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.append(chars[i]); // 先选择当前的
            backtracking(chars, used, path);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0808 leetCode0808 = new LeetCode0808();
        System.out.println(Arrays.toString(leetCode0808.permutation("qqe")));
    }
}