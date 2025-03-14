package org.newrain.problems.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class TreeToDoublyList {



    /**
     * 左指针需要指向前驱，树中节点的右指针需要指向后继
     *
     * @param root
     * @return
     */
    static List<Node> list = null;
    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        list = new ArrayList<>();
        dfs(root, list);
        int size = list.size();
        Node head = list.get(0);
        for (int i = 0; i < size; i++) {
            Node node = list.get(i);
            if (i + 1 < size) {
                Node next = list.get(i + 1);
                node.right = next;
                next.left = node;
            } else {
                node.right = head;
                head.left = node;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node left1 = new Node(2);
        Node right1 = new Node(5);
        root.left = left1;
        root.right = right1;
        Node leftRoot = new Node(1);
        left1.left = leftRoot;
        left1.right = new Node(3);
        treeToDoublyList(root);
    }

    public static void dfs(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}