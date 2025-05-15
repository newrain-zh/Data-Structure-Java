package org.newrain.example.structure.tree;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean                  isEnd    = false; // 是否是词的结束
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
             根
             │
             └── 中
                  │
                  ├── (end)              ← 表示“中”是一个完整词
                  ├── 国 (end)           ← “中国”
                  ├── 华 (end)           ← “中华”
                  ├── 心 (end)           ← “中心”
                  └── 秋
                       │
                       └── 节 (end)       ← “中秋节”
     */
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isEnd = true;
    }

    /*
       查询完整词语是否存在
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEnd;
    }

    public boolean startWith(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEnd;
    }

    // 私有：查找某个字符串最后对应的节点
    private TrieNode searchNode(String text) {
        TrieNode node = root;
        for (char ch : text.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    public void autoComplete(String prefix) {
        TrieNode node = searchNode(prefix);
        if (node == null) {
            System.out.println("无匹配项");
            return;
        }
        dfs(node, new StringBuilder(prefix));
    }


    private void dfs(TrieNode node, StringBuilder path) {
        if (node.isEnd) {
            System.out.println(path.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            path.append(entry.getKey());
            dfs(entry.getValue(), path);
            path.deleteCharAt(path.length() - 1);
        }
    }


    // 简单测试
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("中国");
        trie.insert("中华");
        trie.insert("中秋节");
        trie.insert("中心");
        trie.insert("中医");
        trie.insert("中国人");
//        trie.insert("中");

        System.out.println(trie.search("中国"));
        System.out.println(trie.search("中"));
        trie.autoComplete("中");
    }
}