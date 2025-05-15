package org.newrain.problems.problem.backtracking;

import java.util.*;

/**
 * LeetCode.784 字母大小写全排列
 */
public class LeetCode784 {

    List<String> ans    = new ArrayList<>();
    Set<String>  result = new HashSet<>();

    public List<String> letterCasePermutation(String s) {
        char[] array = s.toCharArray();
        backtrack(array, 0);
        return ans;
    }

    private void backtrack(char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }
        char current = chars[index];
        if ((current >= 'a' && current <= 'z') || (current >= 'A' && current <= 'Z')) {
            System.out.println("1->char=" + current + " ,chars=" + Arrays.toString(chars) + ",index=" + index);
            backtrack(chars, index + 1); // 分支 1
            chars[index] ^= 32;
            backtrack(chars, index + 1); // 分支 2
            System.out.println("2->chars=" + Arrays.toString(chars) + ",index=" + index);
            chars[index] = current;
        } else {
            backtrack(chars, index + 1);
        }
    }

    public static void testCase1() {
//        List<String> strings = new LeetCode784().letterCasePermutation("zHAulfv");
        List<String> strings = new LeetCode784().letterCasePermutation("a1b");
        System.out.println(Arrays.toString(strings.toArray()));
        System.out.println("生成数组长度:" + strings.size());
    }


    public static void testCase2() {
        List<String> strings = new LeetCode784().letterCasePermutation1("zHAulfv");
        System.out.println(Arrays.toString(strings.toArray()));
        System.out.println("生成数组长度:" + strings.size());
    }


    public static void main(String[] args) {
        testCase1();
//        testCase2();
    }


    /**
     * 错误代码
     *
     * @param s
     * @return
     */
    public List<String> letterCasePermutation1(String s) {
        char[] array = s.toCharArray();
        result.add(s);
        backtrack1(array, 0);
        return new ArrayList<>(result);
    }

    private void backtrack1(char[] arr, int start) {
        for (int i = start; i < arr.length; i++) {
            if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')) { //
                result.add(new String(arr));
                backtrack(arr, i + 1);
                arr[i] ^= 32;
            }
        }
    }
}