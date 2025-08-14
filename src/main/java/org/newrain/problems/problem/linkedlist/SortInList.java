package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortInList {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        ListNode      dummy = head;
        List<Integer> list  = new ArrayList<>();
        while (dummy != null) {
            list.add(dummy.val);
            dummy = dummy.next;
        }
        Collections.sort(list);
        ListNode ans = new ListNode(-1);
        ListNode pre = ans;
        for (int i = 0; i < list.size(); i++) {
            ListNode listNode = new ListNode(list.get(i));
            pre.next = listNode;
            pre = pre.next;
        }
        return ans.next;
    }
}