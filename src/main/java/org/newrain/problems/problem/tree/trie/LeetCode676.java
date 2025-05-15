package org.newrain.problems.problem.tree.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode676 {

    static class MagicDictionary {

        private Map<Integer, Set<String>> dict;

        public MagicDictionary() {
            dict = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                int len = word.length();
                dict.putIfAbsent(len, new HashSet<>());
                dict.get(len).add(word);
            }
        }

        public boolean search(String searchWord) {
            int         len   = searchWord.length();
            Set<String> words = dict.get(len);
            if (words == null) {
                return false;
            }
            char[] arr = searchWord.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) {
                        continue;
                    }
                    arr[i] = c;
                    String modified = new String(arr);
                    if (words.contains(modified)) {
                        return true;
                    }
                }
                arr[i] = original;
            }
            return false;
        }


        public static void main(String[] args) {
            MagicDictionary magicDictionary = new MagicDictionary();
            magicDictionary.buildDict(new String[]{"hello", "leetcode"});
            System.out.println(magicDictionary.search("hello")); // 返回 False
            System.out.println(magicDictionary.search("hhllo")); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
            System.out.println(magicDictionary.search("hell")); // 返回 False
            System.out.println(magicDictionary.search("leetcoded")); // 返回 False
        }
    }


/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
}