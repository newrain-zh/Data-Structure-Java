package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.*;

/**
 * LeetCode.515 在每个树行中找最大值
 */
public class LeetCode515 {


    public static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        while (!queue.isEmpty()) {
            int           size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    list.add(poll.left.val);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    list.add(poll.right.val);
                }
            }
            if (!list.isEmpty()) {
                if (list.size() == 1) {
                    ans.add(list.get(0));
                } else {
                    int max = Integer.MIN_VALUE;
                    for (Integer i : list) {
                        max = Math.max(i, max);
                    }
                    ans.add(max);
                }
            }
        }
        return ans;
    }


    public static List<Integer> largestValues1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        while (!queue.isEmpty()) {
            int     size = queue.size();
            Integer max  = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    if (max == null) {
                        max = poll.left.val;
                    } else {
                        max = Math.max(max, poll.left.val);
                    }
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    if (max == null) {
                        max = poll.right.val;
                    } else {
                        max = Math.max(max, poll.right.val);
                    }
                }
            }
            if (max != null) {
                ans.add(max);
            }
        }
        return ans;
    }


    public static List<Integer> largestValues2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int max       = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val); // 更新当前层最大值

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(max); // 记录当前层的最大值
        }
        return result;
    }


    public static List<Integer> largestValues3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(0, res, root);
        return res;

    }

    /**
     * 深度遍历
     *
     * @param level
     * @param res
     * @param treeNode
     */
    public static void dfs(int level, List<Integer> res, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (level == res.size()) { // 当前层没有记录过
            res.add(treeNode.val); // 添加当前层的初始值为最大值
        } else {
            res.set(level, Math.max(res.get(level), treeNode.val));
        }
        dfs(level + 1, res, treeNode.left);
        dfs(level + 1, res, treeNode.right);
    }


    public void getDeep(TreeNode treeNode, int deep, List<Integer> ans) {
        if (treeNode == null) {
            return;
        }
        if (deep == ans.size()) {
            ans.add(treeNode.val);
        } else if (treeNode.val > ans.get(deep)) {
            ans.set(deep, treeNode.val);
        }
        deep++;
        getDeep(treeNode.left, deep, ans);
        getDeep(treeNode.right, deep, ans);
    }

    /**
     * dfs 获取每层的值
     * @param treeNode
     * @param deep
     * @param map
     */
    public static void getMapDeep(TreeNode treeNode, int deep, Map<Integer, List<Integer>> map) {
        if (treeNode == null) {
            return;
        }
        if (deep == map.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(treeNode.val);
            map.put(deep, list);
        } else {
            List<Integer> list = map.get(deep);
            list.add(treeNode.val);
            map.put(deep, list);
        }
        deep++;
        getMapDeep(treeNode.left, deep, map);
        getMapDeep(treeNode.right, deep, map);

    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 3, 2, 5, 3, null, 9});
//        System.out.println(Arrays.toString(largestValues(treeNode).toArray()));
        Map<Integer, List<Integer>> map = new HashMap<>();
        getMapDeep(treeNode, 0, map);
        System.out.println("=====");
    }
}