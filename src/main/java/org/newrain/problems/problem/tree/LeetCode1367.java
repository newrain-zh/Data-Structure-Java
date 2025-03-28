package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.ListNode;
import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.LinkListNodeUtils;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode.1367  二叉树中的链表
 */
public class LeetCode1367 {

    boolean ans = false;

    /**
     * 解题思路二
     * 1. 先将链表转换成数组
     * 2. dfs遍历二叉树，在根节点进行数组和当前路径的比对
     * 3. 回溯节点 依次判断根节点到叶子节点的比对
     */
    public boolean isSubPath(ListNode head, TreeNode root) {

        // 链表转换成数组
        ListNode       dummyNode = head;
        List<ListNode> nodes     = new ArrayList<>();
        while (dummyNode != null) {
            nodes.add(dummyNode);
            dummyNode = dummyNode.next;
        }
        int[] arr = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            arr[i] = nodes.get(i).val;
        }
        // 递归二叉树 进行判断
        dfs(arr, root, new ArrayList<>());
        return ans;

    }


    /**
     * @param arr  链表转换的数组
     * @param root 二叉树
     * @param path 当前路径
     */
    public void dfs(int[] arr, TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        if (ans) {
            return;
        }

        // 这里的代码也修改到后序遍历执行代码处
        // 前序执行添加路径 这样的方式可以使代码看起来优雅一些
        if (root.left == null && root.right == null) { // 到叶子节点进行判断
            path.add(root.val);
            if (hasValue(path, arr)) {
                ans = true;
                return;
            }
            path.remove(path.size() - 1); // 回溯
            return;
        }
        path.add(root.val);
        dfs(arr, root.left, path);
        dfs(arr, root.right, path);
        if (!path.isEmpty()) {
            path.remove(path.size() - 1); // 回溯
        }
    }

    /**
     * 这里将路径和链表进行比对
     *
     * @param path
     * @param arr
     * @return
     */
    public static boolean hasValue(List<Integer> path, int[] arr) {
        int len = arr.length;
        if (len == 1) { // 链表只有一个节点，只要当前路径包含即可
            return path.contains(arr[0]);
        }
        if (len > path.size()) { // 链表长度大于路径 说明不可能存在这样的链表 直接返回
            return false;
        }

        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == arr[0] && (path.size()) - i >= len) { // 在路径中寻找第一个等于链表的节点且当前节点到路径结束的节点的长度要大于链表长度，否则无需寻找
                int left  = i + 1, right = left + len - 1; // 确定左右指针，遍历路径和链表的元素逐个比对
                int index = 1; // 元素匹配则 index ++ 循环结束若 index == arr.length 则说明路径中包含了链表
                while (left < right) {
                    if (path.get(left) == arr[index]) {
                        left++;
                        index++;
                    } else {
                        break;
                    }
                }
                if (index == arr.length) { //
                    return true;
                }
            }
        }
        return false;
    }

    public static void testHasValue() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(8);
        int[] arr = new int[]{4, 2, 8};
        System.out.println(hasValue(list, arr));
    }


    /**
     * 解题思路二
     *
     * @param head
     * @param root
     * @return
     */

    public boolean isSubPath1(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        // 检查当前节点是否可以开始匹配路径
        if (root.val == head.val && checkPath(root, head)) {
            return true;
        }

        // 递归检查左右子树中的其他节点作为起点
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean checkPath(TreeNode treeNode, ListNode listNode) {
        if (listNode == null) return true; // 链表已完全匹配
        if (treeNode == null) return false; // 树节点不足，无法继续匹配

        // 当前节点值不匹配，路径无效
        if (treeNode.val != listNode.val) return false;

        // 继续检查左子树或右子树是否匹配链表的下一个节点
        return checkPath(treeNode.left, listNode.next) || checkPath(treeNode.right, listNode.next);
    }


    public static void main(String[] args) {
//        testHasValue();
        TreeNode     treeNode     = TreeNodeUtils.buildTree(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});
        ListNode     head         = LinkListNodeUtils.get(new int[]{4, 2, 8});
        LeetCode1367 leetCode1367 = new LeetCode1367();
        System.out.println(leetCode1367.isSubPath(head, treeNode));

    }
}