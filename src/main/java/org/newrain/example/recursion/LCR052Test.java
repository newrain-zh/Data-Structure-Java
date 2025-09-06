package org.newrain.example.recursion;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/NYBBNL/description/?envType=problem-list-v2&envId=nwEI8Rqc">...</a>
 */
public class LCR052Test {

    TreeNode dummyNode = new TreeNode(-1);
    // 保存上一节点

    public TreeNode increasingBST(TreeNode root) {
        // 将 prev 重置到 dummyNode 虚拟头节点
        TreeNode test = new TreeNode(-1);
        inOrder(root, test);
        TreeNodeUtils.printTree(test);
        return dummyNode.right;
    }


    /*
     * 普通 TreeNode 参数的问题 public void inOrder(TreeNode node, TreeNode prev)
     * 传递的是当前引用的 副本，方法内修改 prev = node 只是改变副本的指向
     * 递归返回上层时，外部的 prev 仍保持原来的引用
     * * 调用栈层级1: prev → dummy(地址0x100)
     * *   ↳ 调用层级2传入 prev副本 → 0x100
     * *       ↳ 修改副本指向 nodeA(0x200) → 仅层级2可见
     * <p>
     * *    ↳ 返回后层级1的 prev 仍指向 0x100
     *
     * <p>
     * 数组包装的解决方案  public void inOrder(TreeNode node, TreeNode[] resNode)
     * 数组是对象，传递数组参数时传递的是数组引用的 副本
     * 但可以通过数组索引修改其存储的引用，因为所有层级访问的是同一个数组对象,改变的只是数组内容
     * 共享数组对象（地址0x300）:
     * [0] → dummy(0x100)
     * <p>
     * 调用栈层级1: prevWrapper → 0x300
     * ↳ 调用层级2传入 prevWrapper副本 → 0x300
     *      ↳ 修改数组元素 [0] → nodeA(0x200)
     * ↳ 返回后数组内容已变：所有层级访问 [0] 都得到 0x200
     *
     * @param node
     * @param prev
     */

    public void inOrder(TreeNode node, TreeNode prev) {
        if (node == null) {
            return;
        }

        // 注意这里要用成员变量或者数组对象,
        System.out.println("当前值：" + node.val + ",prev:" + prev.val + ",prev.hash=" + prev.hashCode());
        inOrder(node.left, prev);
        node.left = null; // 断开节点的左子树
        prev.right = node; // 前驱的右子 指向当前节点
        prev = node; // 更新前驱节点
        inOrder(node.right, prev);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9};
//        Integer[] arr = new Integer[]{5, 1, 7};
        TreeNode treeNode = TreeNodeUtils.buildTree(arr);
//        TreeNodeUtils.printTree(treeNode);
        System.out.println("====================");
        TreeNode res = new LCR052Test().increasingBST(treeNode);
//        TreeNodeUtils.printTree(res);

    }


}