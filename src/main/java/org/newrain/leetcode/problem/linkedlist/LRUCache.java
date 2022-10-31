package org.newrain.leetcode.problem.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {


    /**
     * 集合作为缓存
     */
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        /**
         * accessOrder 为true 使用访问顺序排序
         *              false 使用插入顺序排序
         */
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            // 移除该map中最老的键和值
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
