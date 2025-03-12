package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.ListNode;
import org.newrain.code.problem.utils.LinkListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group">...</a>
 */
public class LeetCode25 {

    /**
     * time 0ms 击败 100%
     * memory 43.41MB 击败 59.54%
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //计算是否满足 k个节点
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        if (count < k) {
            return head;
        }
        // 反转节点
        ListNode prev = head;
        int index = 0;
        List<ListNode> list = new ArrayList<>(k);
        while (prev != null) {
            if (index == k) { //开始反转
                break;
            }
            index++;
            list.add(prev);
            prev = prev.next;
        }
        // 开始反转
        if (list.size() == k) { // 1->2  2->1
            for (int i = k - 1; i >= 1; i--) {
                list.get(i).next = list.get(i - 1);
            }
            list.get(0).next = null;
        }
        list.get(0).next = reverseKGroup(prev, k); // 2->1->下次递归
        head = list.get(list.size() - 1);
//        LinkListNodeUtils.print("head", head);
//        System.out.println("----------");
        return head;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        // 检查剩余节点是否足够k个
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }
        if (count < k) {
            return head; // 不足k个，无需翻转
        }

        // 翻转当前k个节点
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 递归处理后续链表，并连接到当前段的尾部
        head.next = reverseKGroup(curr, k);
        return prev; // 返回新的头节点
    }

    public static void main(String[] args) {
        ListNode listNode = LinkListNodeUtils.get(new int[]{1, 2, 3, 4, 5}); // 2->1->4->3->5
        LinkListNodeUtils.print(new LeetCode25().reverseKGroup(listNode, 2));
    }
}