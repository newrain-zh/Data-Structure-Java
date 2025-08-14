package org.newrain.problems.problem.linkedlist;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;

public class IsPail {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public static boolean isPail(ListNode head) {
        if (head == null) return true;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        if (sb.length() == 1) return true;
        String[] s = sb.toString().split(" ");

        int l = 0, r = s.length - 1;
        while (l < r) {
            if (!s[l].equals(s[r])) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = LinkListNodeUtils.get(new int[]{-401261, -449050, -456674, -456674, -449050, -401261});
        System.out.println(isPail(listNode));
    }
}