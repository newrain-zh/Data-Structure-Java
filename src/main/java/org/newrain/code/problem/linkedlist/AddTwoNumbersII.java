package org.newrain.code.problem.linkedlist;

/**
 * leetcode.2 两数相加II
 *
 * @author NewRain
 * @link <a href="https://leetcode.cn/problems/add-two-numbers-ii/"></a>
 * @description 两数相加 II
 */
public class AddTwoNumbersII {

    /**
     * 根据题意
     *
     * @param l1
     * @param
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;//保存上一个节点
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            carry = sum / 10; //获取进位
            sum = sum % 10; // 获取本轮相加的值
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    //3,9,9,9,9,9,9,9,9,9
    public static void main(String[] args) {
        //test1
/*        ListNode listNode1 = LinkListNodeUtils.get(new int[]{2, 4, 3});
        ListNode listNode2 = LinkListNodeUtils.get(new int[]{5, 6, 4});
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        LinkListNodeUtils.print(listNode);*/


        ListNode listNode1 = LinkListNodeUtils.get(new int[]{2, 4, 9});
        ListNode listNode2 = LinkListNodeUtils.get(new int[]{5, 6, 4, 9});
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        LinkListNodeUtils.print(listNode);
    }

}