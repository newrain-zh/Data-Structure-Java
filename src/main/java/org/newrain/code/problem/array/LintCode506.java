package org.newrain.code.problem.array;

import java.util.*;

/**
 * @author NewRain
 * @description
 * @link <a href="https://www.lintcode.com/problem/506">lintcode</a>
 * @description 电影推荐
 */
public class LintCode506 {

    /**
     * @param graph:
     * @return nothing
     */
    public static List<List<Integer>> minMalwareSpread(List<List<Integer>> graph) {
        List<List<Integer>> res = new ArrayList<>(graph.size());
        for (int i = 0; i < graph.size(); i++) {
            List<Integer> data = getData(graph.get(i), graph, i);
            res.add(data);
        }
        return res;
    }

    /**
     * @param graph 所有观影记录
     * @param pos   数组位置
     * @return 获取被推荐人以外的数据
     */
    public static List<List<Integer>> getOthers(List<List<Integer>> graph, int pos) {
        List<List<Integer>> list = new ArrayList<>(graph.size() - 1);
        for (int i = 0; i < graph.size(); i++) {
            if (i != pos) {
                list.add(graph.get(i));
            }
        }
        return list;
    }

    /**
     * @param currGraph 当前要推荐的拥护的观影集合
     * @param others    其他人看电影的集合
     * @param index     当前数组位置
     * @return 推荐的电影集合
     */
    public static List<Integer> getData(List<Integer> currGraph, List<List<Integer>> others, int index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < others.size(); i++) {
            if (i == index) {
                continue;
            }
            //判断有无交集
            List<Integer> currUsrMovies = new ArrayList<>(currGraph);
            currUsrMovies.retainAll(new ArrayList<>(others.get(i)));
            if (!currUsrMovies.isEmpty()) {
                result.addAll(others.get(i));
            }
        }
        result.retainAll(currGraph);
        if (result.isEmpty()) {
            return result;
        }
        //做数据排序的处理
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer r : result) {
            countMap.put(r, countMap.getOrDefault(r, 0) + 1);
        }
        Set<Integer> keys = countMap.keySet();
        List<Integer> data = new ArrayList<>(countMap.keySet());
        Map<Integer, Integer> score = getScore(keys, getOthers(others, index), currGraph);
        //先按相关度从大到小排序，再按频率从大到小排序，最后如果相关度和频率都一样，按序号从小到大排序。
        data.sort((o1, o2) -> {
            if (!score.get(o1).equals(score.get(o2))) {
                return score.get(o2) - score.get(o1);
            }
            if (!countMap.get(o1).equals(countMap.get(o2))) {
                return countMap.get(o2) - (countMap.get(o1));
            }
            return o1 - o2;
        });
        if (data.size() > 5) {
            return data.subList(0, 5);
        }
        return data;
    }

    /**
     * 获取权重
     *
     * @param keys      电影id
     * @param others    他人的观影记录
     * @param currGraph 当前被推荐人的观影记录
     * @return 电影Id权重分
     */
    public static Map<Integer, Integer> getScore(Set<Integer> keys, List<List<Integer>> others, List<Integer> currGraph) {
        Map<Integer, Integer> scoreMap = new HashMap<>(keys.size());
        for (Integer key : keys) {
            for (List<Integer> integers : others) {
                if (integers.contains(key)) {
                    ArrayList<Integer> list = new ArrayList<>(integers);
                    list.retainAll(currGraph);
                    scoreMap.put(key, scoreMap.getOrDefault(key, 0) + list.size());
                }
            }
        }
        return scoreMap;
    }


    public static void main(String[] args) {
        int[][] ints = {{7, 9, 17, 18}, {2, 3, 4, 5, 6, 7, 8, 9, 13, 14, 15}, {2, 3, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 19}, {1, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {1, 2, 3, 4, 5, 6, 8, 9, 10, 14, 15, 16, 17, 18}, {1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19}, {1, 3, 5, 7, 8, 10, 11, 12, 16, 17, 18, 19}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {4, 10, 19}, {1, 2, 3, 4, 6, 7, 9, 12, 13, 14, 15, 16, 18}, {1, 2, 3, 4, 5, 7, 9, 10, 13, 14, 15, 16, 17, 18, 19}, {1, 4, 5, 8, 9, 12}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19}};
        List<List<Integer>> list = new ArrayList<>();
        for (int[] anInt : ints) {
            List<Integer> sub = new ArrayList<>();
            for (int i : anInt) {
                sub.add(i);
            }
            list.add(sub);
        }
        System.out.println(minMalwareSpread(list));
    }

}