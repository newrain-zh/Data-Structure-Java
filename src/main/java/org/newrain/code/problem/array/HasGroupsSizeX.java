package org.newrain.code.problem.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author NewRain
 * @description 卡牌分组
 * @link <a href="https://www.lintcode.com/problem/1728/">lintcode</a>
 */
public class HasGroupsSizeX {

    /**
     * 解题思路为 存入所有数的出现次数
     * 原始数组升序排序
     * 遍历集合 查看left 和left+1的出现次数是否相等、或次数能整除
     *
     * @param deck 原始数组
     * @return 是否能组成卡牌
     */
    public static boolean hasGroupsSizeX1(List<Integer> deck) {
        if (deck == null || deck.isEmpty() || deck.size() == 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deck) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        Collections.sort(deck);
        int left = 0;
        while (left < deck.size() - 1) {
            if (map.get(deck.get(left)).equals(map.get(deck.get(left + 1))) || map.get(deck.get(left)) / map.get(deck.get(left + 1)) == map.get(deck.get(left)) || map.get(deck.get(left)) / map.get(deck.get(left + 1)) == 0) {
                left++;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3, 4, 4, 3, 2, 1).collect(Collectors.toList());
        List<Integer> collect1 = Stream.of(1, 1, 1, 1, 2, 2, 2, 2, 2, 2).collect(Collectors.toList());
        System.out.println(hasGroupsSizeX1(collect1));
    }
}