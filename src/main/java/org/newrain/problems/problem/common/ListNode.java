package org.newrain.problems.problem.common;

/**
 * @author NewRain
 * @description 链表节点类
 */
public class ListNode {

    public int val;

    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.val + "";
    }

    public static void main(String[] args) {

    }
}