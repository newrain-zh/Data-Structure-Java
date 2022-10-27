package org.newrain.example.structure.list.linkedlist;

/**
 * @author newRain
 * @description 链表节点
 */
public class Node {
    /**
     * 数据域
     */
    int data;
    /**
     * 指针域
     */
    Node next;

    Node() {
    }

    /**
     * 构造器用于初始化 节点类
     *
     * @param data 数据
     */
    Node(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
