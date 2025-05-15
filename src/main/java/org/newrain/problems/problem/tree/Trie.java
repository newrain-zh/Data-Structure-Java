package org.newrain.problems.problem.tree;

import java.util.HashMap;
import java.util.Map;


class TrieNode {
    // 支持中英文
    public Map<Character, TrieNode> childNode;
    public boolean                  isEnd;

    public TrieNode() {
        childNode = new HashMap<>();
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 向前缀树中插入字符串 word 。
    public void insert(String word) {
        char[]   charArray = word.toCharArray();
        TrieNode node      = root;
        for (char ch : charArray) {
            if (!node.childNode.containsKey(ch)) {
                node.childNode.put(ch, new TrieNode());
            }
            node = node.childNode.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        char[]   charArray = word.toCharArray();
        TrieNode node      = root;
        for (char ch : charArray) {
            if (!node.childNode.containsKey(ch)) {
                return false;
            }
            node = node.childNode.get(ch);
        }
        return node.isEnd;
    }

    private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.childNode.get(ch);
            if (node == null) {
                return null;
            }
        }
        return node;
    }


    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app"));       // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */