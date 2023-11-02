package org.newrain.code.problem.array;

import java.util.*;

public class FindRestaurant {

    public static void main(String[] args) {
        //["Shogun", "Tapioca Express", "Burger King", "KFC"]
        //["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//        String[] restaurant = findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
//        System.out.println(Arrays.toString(restaurant));
        //["zs","KFC"]
        //["zs","koabb","KFC"]
        String[] restaurant1 = findRestaurant(new String[]{"zs", "KFC"}, new String[]{"zs", "koabb", "KFC"});
        System.out.println(Arrays.toString(restaurant1));
    }

    /**
     * @param list1: a list of strings
     * @param list2: a list of strings
     * @return: the common interest with the least list index sum
     * we will sort your return value in output
     */
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>(list1.length);
        Map<String, Integer> map2 = new HashMap<>(list2.length);
        Set<String> set = new HashSet<>(Math.min(list1.length, list2.length));
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
            set.add(list1[i]);
        }
        //交集
        Set<String> andSet = new HashSet<>(Math.min(list1.length, list2.length));
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
            if (set.contains(list2[i])) {
                andSet.add(list2[i]);
            }
        }
        Map<String, Integer> res = new HashMap<>(andSet.size());
        int min = Integer.MAX_VALUE;
        for (String s : andSet) {
            int len = map1.get(s) + map2.get(s);
            res.put(s, len);
            min = Math.min(len, min);
        }
        List<String> resList = new ArrayList<>(andSet.size());

        for (String key : res.keySet()) {
            if (res.get(key) == min) {
                resList.add(key);
            }
        }
        return resList.toArray(new String[]{});
    }

    public static String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        //交集
        List<String> resList = new ArrayList<>(Math.min(list1.length, list2.length));
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) { //说明有交集
                int j = map1.get(list2[i]);
                if (i + j < minLen) {
                    resList.clear();
                    resList.add(list2[i]);
                    minLen = i + j;
                } else if (i + j == minLen) {
                    resList.add(list2[i]);
                }
            }
        }
        return resList.toArray(new String[]{});

    }

}