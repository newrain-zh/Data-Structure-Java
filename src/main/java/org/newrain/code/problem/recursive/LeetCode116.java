package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.Node;
import org.newrain.code.problem.utils.TreeUtils;

import java.util.*;

/**
 * @author NewRain
 * // TODO 待练习、连接其他解法
 */
public class LeetCode116 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        List<List<Node>> res = new ArrayList<>();
        levelOrder(root, res);
        return root;
    }

    /**
     * 层序遍历 分层遍历
     *
     * @param root
     * @param res
     * @return
     */
    public static List<List<Node>> levelOrder(Node root, List<List<Node>> res) {
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node poll = queue.poll(); // 出队列
                level.add(poll);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(level);
            for (int i = 0; i < level.size(); i++) {
                level.get(i).next = i + 1 < level.size() ? level.get(i + 1) : null;
            }
            level.forEach(v -> System.out.print(v.next + "->"));
            System.out.println();
            System.out.println("====" + level);
        }
        return res;
    }

    /**
     * 层序遍历示例-不分层
     *
     * @return
     */
    public static List<Integer> levelOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);  // 将根节点入队

        while (!queue.isEmpty()) {
            Node node = queue.poll();  // 出队当前节点
            result.add(node.val);  // 访问当前节点
            if (node.left != null) {
                queue.offer(node.left);  // 左子节点入队
            }
            if (node.right != null) {
                queue.offer(node.right); // 右子节点入队
            }
            queue.forEach(v -> System.out.print(v.val + "->"));
            System.out.println();
        }
        return result;
    }


    /**
     * 递归层序遍历示例
     *
     * @param depth
     * @param res
     * @param node
     */
    public static void levelByRecursive(int depth, List<List<Node>> res, Node node) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node);
        System.out.println(node.val);
        System.out.println("当前深度 => " + depth);
        levelByRecursive(depth, res, node.left);
        levelByRecursive(depth, res, node.right);
    }


    /**
     * 使用前序遍历顺序根 → 左 → 右
     *
     * @param root
     * @param last 记录每层最后一个节点
     * @param deep
     */
    public void recursion(Node root, List<Node> last, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (last.size() < deep) {
            last.add(root);
        } else {
            last.get(deep - 1).next = root;
            last.set(deep - 1, root);
        }
        System.out.println("node.val=" + root.val);
        System.out.println("list =" + Arrays.toString(last.toArray()));
        recursion(root.left, last, deep);
        recursion(root.right, last, deep);
        System.out.println("==========");
    }

    public static void main(String[] args) {
//        new LeetCode116().testConnect();
        new LeetCode116().testConnect1();
//        new LeetCode116().testConnect2();
    }


    public void testConnect() {
        Node node = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        connect(node);
    }


    public void testConnect1() {
        Node node = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeUtils.printTree(node);
        connect1(node);
    }

    public void testConnect2() {
        Node node = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});
        connect1(node);
    }


    public Node connect1(Node root) {
        List<Node> last = new ArrayList<>();
        if (root == null) {
            return root;
        }
        recursion(root, last, 0);
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node current = root; // 当前层的最左节点
        // 外层循环：处理每一层，直到叶子层（没有子节点）
        while (current.left != null) {
            Node levelStart = current;
            // 内层循环：遍历当前层的每个节点
            while (levelStart != null) {
                // 连接左子节点到右子节点
                levelStart.left.next = levelStart.right;
                // 如果当前节点有右侧邻居，连接右子节点到邻居的左子节点
                if (levelStart.next != null) {
                    levelStart.right.next = levelStart.next.left;
                }
                // 移动到当前层下一个节点
                levelStart = levelStart.next;
            }
            // 移动到下一层的最左节点
            current = current.left;
        }
        return root;
    }

}