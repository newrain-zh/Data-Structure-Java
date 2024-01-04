package org.newrain.code.problem.linkedlist;

/**
 * 生成链表 打印链表相关工具类
 *
 * @author newrain
 * @description 链表工具类
 */
public class LinkListNodeUtils {


    public static ListNode get(int[] arr) {
        ListNode curr = new ListNode(-1);
        ListNode tail = new ListNode(arr[0]);
        curr.next = tail;
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            tail.next = listNode;
            tail = listNode;
        }
        return curr.next;
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            if (listNode.next != null){
                System.out.print(listNode.val + ",");
            }else {
                System.out.println(listNode.val);
            }
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        get(new int[]{1, 2, 3});
    }

}