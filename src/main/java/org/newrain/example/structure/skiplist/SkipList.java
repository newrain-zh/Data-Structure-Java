package org.newrain.example.structure.skiplist;

import java.util.Random;

/**
 * 跳跃表节点
 */
class SkipListNode {
    int key;//节点key
    int value;//节点值
    SkipListNode next; //后续节点
    SkipListNode down; //下层节点

    public SkipListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class SkipList {
    private static final double PROBABILITY = 0.5; // 节点在上一级索引的概率

    private SkipListNode head; //头节点
    private int maxLevel;//最大层级
    private final Random random;

    public SkipList() {
        head = new SkipListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        maxLevel = 0;
        random = new Random();
    }

    /**
     * 写入操作
     * @param key
     * @param value
     */
    public void insert(int key, int value) {
        int level = 0;
        while (random.nextDouble() < PROBABILITY) {
            level++;
        }
        while (level > maxLevel) {
            addEmptyLevel();
        }
        SkipListNode newNode = new SkipListNode(key, value);
        SkipListNode current = head;
        for (int i = maxLevel; i >= 0; i--) {
            while (current.next != null && current.next.key < key) {
                current = current.next;
            }
            if (i <= level) {
                newNode.next = current.next;
                current.next = newNode;
                newNode.down = (i > 0) ? newNode : null;
                newNode = newNode.down;
            }
            current = current.down;
        }
    }

    public void remove(int key) {
        SkipListNode current = head;
        for (int i = maxLevel; i >= 0; i--) {
            while (current.next != null && current.next.key < key) {
                current = current.next;
            }
            if (current.next != null && current.next.key == key) {
                current.next = current.next.next;
            }
            current = current.down;
        }
    }

    public Integer search(int key) {
        SkipListNode current = head;
        for (int i = maxLevel; i >= 0; i--) {
            while (current.next != null && current.next.key < key) {
                current = current.next;
            }
            if (current.next != null && current.next.key == key) {
                return current.next.value;
            }
            current = current.down;
        }
        return null;
    }

    private void addEmptyLevel() {
        SkipListNode newHead = new SkipListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        newHead.down = head;
        head = newHead;
        maxLevel++;
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(5, 100);
        System.out.println(skipList.maxLevel);
    }
}