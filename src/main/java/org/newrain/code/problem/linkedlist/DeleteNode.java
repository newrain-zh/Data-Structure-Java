package org.newrain.code.problem.linkedlist;

import org.newrain.code.problem.common.ListNode;

/**
 * leetcode.237 删除链表中的节点
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * <p>
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 * <p>
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * <p>
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 * <p>
 * 给定节点的值不应该存在于链表中。
 * <p>
 * 链表中的节点数应该减少 1。
 * <p>
 * node 前面的所有值顺序相同。
 * <p>
 * node 后面的所有值顺序相同。
 */
public class DeleteNode {


    /**
     * 例如[4,5,1,9]这个链表 要删除5这个第二节点
     * <p>
     * 先将5节点变更同next节点一样的值 这样链表就变更为[4,1,1,9]
     * <p>
     * 然后再将之前是第二节点的指针指向9这个节点
     * <p>
     * 最后链表变更为[4,1,9]
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val; //先将当前节点的值变更为下一个节点
        node.next = node.next.next; //然后将下一个节点删除
    }

}