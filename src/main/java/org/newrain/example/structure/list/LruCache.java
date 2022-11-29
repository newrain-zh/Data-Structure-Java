package org.newrain.example.structure.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NewRain
 * @description LRU缓存实现
 */
public class LruCache {

    public int size;
    /**
     * 负载因子
     */
    public int capacity;
    public Node head;
    public Node tail;
    private Map<Integer, Node> cache = new HashMap<>();

    public LruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        //获取节点 如果节点存在则将节点添加到head节点之后
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNodeAtHead(node);
        return node.value;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //查询是否存在元素，如果存在元素，就将元素前移
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addNodeAtHead(node);
            return;
        }
        //缓存满了 进行清理链表尾部
        if (size == capacity) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        //添加新节点到head节点后
        Node newNode = new Node(key, value);
        addNodeAtHead(newNode);
        cache.put(key, newNode);
        size++;
    }

    /**
     * 根据key删除节点
     *
     * @param key
     */
    public void remove(int key) {
        Node node = cache.get(key);
        if (node != null) {
            removeNode(node);
            cache.remove(key);
        }
    }

    /**
     * 删除节点
     *
     * @param node
     */
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    /**
     * 添加节点到head节点后
     *
     * @param node
     */
    private void addNodeAtHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    /**
     * 链表节点
     */
    public static class Node {
        public Node next;
        public Node prev;
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
