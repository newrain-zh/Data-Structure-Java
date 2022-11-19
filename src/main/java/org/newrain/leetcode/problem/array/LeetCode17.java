package org.newrain.leetcode.problem.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author newRain
 */
public class LeetCode17 {


    Map<Character, String> phoneMap = new HashMap<Character, String>(8) {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> combinations = new ArrayList<>();


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(digits, 0, new StringBuilder());
        return combinations;
    }

    public void backtrack(String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {

    }


}
