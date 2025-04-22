package org.newrain.problems.problem.backtracking;

import java.util.*;

/**
 * 电话号码组合
 */
public class LintCode425 {

    private        List<String>        ans  = new ArrayList<>();
    private static Map<String, String> dict = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>(0);
        }

        // 先构建字典
        dfs(digits, 0, new StringBuilder());
        return ans;

    }

    public void dfs(String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            ans.add(path.toString());
            return;
        }
        // 获取字典值
        String value = dict.get(digits.charAt(index) + "");
        if (value.isEmpty()) { // 或者 判断 digits.charAt(index) =='1'
            return;
        }
        for (int i = 0; i < value.length(); i++) {
            path.append(value.charAt(i)); // 选择元素
            dfs(digits, index + 1, path); // selectIndex 始终传 0 因为下一层的元素
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new LintCode425().letterCombinations("23");
        System.out.println(Arrays.toString(list.toArray()));
    }


}