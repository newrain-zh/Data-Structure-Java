package org.newrain.code.problem.array;

import java.util.*;

/**
 *  题目：统计出现过一次的公共字符串
 *  给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 */
public class CountWords {

    /**
     * 利用map 还有更优秀的解法
     * @param words1
     * @param words2
     * @return
     */
    public int countWords(String[] words1, String[] words2) {
        String[] unique1 = getUnique(words1);
        String[] unique2 = getUnique(words2);
        Set<String> set = new HashSet<>();
        for (String s : unique1) {
            set.add(s);
        }
        int ans = 0;
        for (String s : unique2) {
            if (set.contains(s)){
                ans++;
            }
        }
        return ans;

    }

    static String[] getUnique(String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Set<String> set = map.keySet();
        List<String> ret = new ArrayList<>(set.size());
        for (String key : set) {
            if (map.get(key) == 1) {
                ret.add(key);
            }
        }
        String[] strArr = new String[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            strArr[i] = ret.get(i);
        }
        return strArr;

    }
}