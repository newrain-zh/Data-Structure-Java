package org.newrain.code.problem.recursive;

import org.newrain.code.problem.common.Node;
import org.newrain.code.problem.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author newRain
 */
public class LeetCode117 {

    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        levelOrder(root);
        return root;
    }

    public static List<List<Node>> levelOrder(Node root) {
        List<List<Node>> res = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Node> list = new ArrayList<>();
            int level = deque.size();
            for (int i = 0; i < level; i++) {
                Node poll = deque.poll();
                list.add(poll);
                if (poll == null) {
                    continue;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void testLevelOrder() {
        Node node = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        List<List<Node>> list = levelOrder(node);
        System.out.println("==== testLevelOrder ====");
    }

    public static void main(String[] args) {
        testLevelOrder();
    }

}