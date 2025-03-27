package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode.109 有序链表转换二叉搜索树
 */
public class LeetCode109 {


    public TreeNode sortedListToBST(ListNode head) {
        // 首先找到链表的中间节点
        ListNode       dummyNode = head;
        List<ListNode> list      = new ArrayList<>();
        while (dummyNode != null) {
            list.add(dummyNode);
            dummyNode = dummyNode.next;
        }
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return new TreeNode(list.get(0).val);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).val;
        }
        return buildTree(arr, 0, arr.length - 1);
    }

    public TreeNode buildTree(int[] arr, int l, int r) {
        if (l > r) {
            System.out.println(" result ==>l=" + l + ",r=" + r);
            return null;
        }
        int mid = (l + r) / 2;
        System.out.println("l=" + l + ",r=" + r + ",mid=" + mid);
        TreeNode curr = new TreeNode(arr[mid]);
        curr.left  = buildTree(arr, l, mid - 1);
        curr.right = buildTree(arr, mid + 1, r);
        return curr;
    }


    public TreeNode sortedListToBST1(ListNode head) {
        ListNode dummyNode = head;
        ListNode slow      = dummyNode;
        ListNode fast      = dummyNode;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public TreeNode buildTree(ListNode left, ListNode right) {


        return null;
    }


    public static void main(String[] args) {
        LeetCode109 leetCode109 = new LeetCode109();
        TreeNode    treeNode    = leetCode109.sortedListToBST(LinkListNodeUtils.get(new int[]{-10, -3, 0, 5, 9}));
        TreeNodeUtils.printTree(treeNode);
        System.out.println("============");
        System.out.println(7 / 2);
    }


}