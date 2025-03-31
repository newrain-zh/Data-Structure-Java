package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode17 电话号码字母的组合
 * TODO 改成回溯 怎么写
 */
public class LeetCode17 {


    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        // 数字到字母的映射表（索引0和1无意义）
        String[] mapping      = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char     firstDigit   = digits.charAt(0); // 获取第一个字母
        String   firstLetters = mapping[firstDigit - '0']; // 获取第一个数字对应的字母表
        // 先将 每个字母加入数组 例如 2对应的 abc  ["a","b","c"]
        // 以 digits = "234"为例子，"abc" "def" "ghi"
        // 首先要以 "abc" 为基础去遍历，然后和 "def" "ghi" 来凑成组合
        // a+d+g a+d+h a+d+i .... a+f+i
        // b+d+g b+d+h b+d+i .... a+f+i
        // c+d+g c+d+h c+d+i .... c+f+i

        for (char c : firstLetters.toCharArray()) {
            ans.add(String.valueOf(c));
        }
        for (int i = 1; i < digits.length(); i++) { // [d,e,f]
            char         currentDigit = digits.charAt(i); // 获取要处理的数字
            String       letters      = mapping[currentDigit - '0']; // 获取要处理的数字对应的字母表
            List<String> temp         = new ArrayList<>();
            for (String s : ans) {
                for (char c : letters.toCharArray()) {
                    temp.add(s + c);
                }
            }
            ans = temp;
            System.out.println(temp);
            System.out.println("===========");
        }
        return ans;
    }


    public static final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 队列解法 BFS
     */
    public static List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for (char digit : digits.toCharArray()) {
            String letters = MAPPING[digit - '0'];
            int    size    = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll(); // 当前的组合出列
                for (char c : letters.toCharArray()) {
                    queue.offer(current + c); // // 组成新的组合
                }
            }
        }
        // 因为有出列的操作 最后队列的组合就是最后的生成的组合
        ans.addAll(queue);
        return ans;
    }

    public static List<String> letterCombinations3(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;

    }

    /**
     * 回溯解法
     *
     * @param digits
     * @param index
     * @param path
     * @param result
     */
    private static void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        char   digit   = digits.charAt(index);
        String letters = MAPPING[digit - '0'];
        for (char c : letters.toCharArray()) {
            path.append(c);  // a
            backtrack(digits, index + 1, path, result); // "23",1,"a",[]
            path.deleteCharAt(path.length() - 1);
        }

    }


    /**
     * TODO 此代码作为错误示范
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        // 数字到字母的映射表（索引0和1无意义）
        String[] mapping      = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char     firstDigit   = digits.charAt(0); // 获取第一个字母
        String   firstLetters = mapping[firstDigit - '0']; // 获取第一个数字对应的字母表
        if (digits.length() == 1) {
            for (char c : firstLetters.toCharArray()) {
                ans.add(c + "");
            }
            return ans;
        }
        // 先将 每个字母加入数组 例如 2对应的 abc  ["a","b","c"]
        // 以 digits = "234"为例子，"abc" "def" "ghi"
        // 首先要以 "abc" 为基础去遍历，然后和 "def" "ghi" 来凑成组合
        // a+d+g a+d+h a+d+i .... a+f+i
        // b+d+g b+d+h b+d+i .... a+f+i
        // c+d+g c+d+h c+d+i .... c+f+i
        // 这里的思路主要是先组成后面的字符，然后和第一个字符组合
        char[]                charArray1 = digits.toCharArray();
        List<List<Character>> list       = new ArrayList<>();


        // TODO 这里要考虑输入的是两个数字的问题
        // TODO 例如 输入 "23" 后面的如何组
        // TODO 这里的关键为先将第一个要组成的元素构成列表这样我只要遍历这个列表和后面元素组成即可
        // TODO 这样写的方式比较简洁
        // TODO 因为如果数组长度为1的情况 还需要额外判断
        List<String> after = new ArrayList<>();
        if (digits.length() > 2) {
            for (int i = 1; i < charArray1.length; i++) {
                String          string     = mapping[charArray1[i] - '0'];
                char[]          charArray2 = string.toCharArray();
                List<Character> temp       = new ArrayList<>();
                for (char c : charArray2) {
                    temp.add(c);
                }
                list.add(temp);
            }
            for (int i = 0; i < list.size(); i++) {
                List<String> strings = new ArrayList<>();
                if (i + 1 == list.size()) {
                    break;
                }
                int next = i + 1;
                for (char c : list.get(i)) {
                    for (char character : list.get(next)) {
                        strings.add(c + String.valueOf(character));
                    }
                }
                after.addAll(strings);
            }
        } else {
            String string = mapping[digits.charAt(1) - '0'];
            for (char c : string.toCharArray()) {
                after.add(c + "");
            }
        }
        String string = mapping[digits.charAt(0) - '0'];
        for (char c : string.toCharArray()) {
            for (String an : after) {
                ans.add(c + an);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        List<String> strings = letterCombinations("234");
        List<String> strings = letterCombinations2("234");
        System.out.println(strings.size());
        System.out.println(strings);
//        List<String> strings1 = letterCombinations1("5678");
//        System.out.println(strings1);
//        System.out.println(strings1.size());
    }
}