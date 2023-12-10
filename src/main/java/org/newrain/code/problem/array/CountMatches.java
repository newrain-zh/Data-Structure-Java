package org.newrain.code.problem.array;

import java.util.List;


/**
 * 题目：leetcode.1773 统计匹配检索规则的物品数量
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * <p>
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 */
public class CountMatches {


    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int p = 0;
        if ("color".equals(ruleKey)) {
            p = 1;
        } else if ("name".equals(ruleKey)) {
            p = 2;
        }
        int ans = 0;
        for (List<String> item : items) {
            if (item.get(p).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;

    }
}