package org.newrain.problems.problem.tree.trie;

/**
 * LeetCode.211 添加与搜索单词 - 数据结构设计
 */
public class LeetCode211 {


    static class WordDictionary {
        WordNode root;

        public WordDictionary() {
            root = new WordNode();
        }

        public void addWord(String word) {
            if (word.isEmpty()) {
                return;
            }
            char[]   charArray = word.toCharArray();
            WordNode node      = root;
            for (char ch : charArray) {
                int index = ch - 'a';
                if (node.childNode[index] == null) {
                    node.childNode[index] = new WordNode();
                }
                node = node.childNode[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return searchInNode(word, 0, root);
        }

        private boolean searchInNode(String word, int pos, WordNode node) {
            if (node == null) {
                return false;
            }
            if (pos == word.length()) {
                return node.isEnd;
            }
            char c = word.charAt(pos);
            if (c == '.') {
                for (WordNode child : node.childNode) {
                    if (searchInNode(word, pos + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                return searchInNode(word, pos + 1, node.childNode[index]);
            }
        }
    }

    static class WordNode {
        WordNode[] childNode;
        boolean    isEnd;

        public WordNode() {
            childNode = new WordNode[26];
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // 返回 False
        System.out.println(wordDictionary.search("bad")); // 返回 True
        System.out.println(wordDictionary.search(".ad")); // 返回 True
        wordDictionary.search("b.."); // 返回 True

    }


}