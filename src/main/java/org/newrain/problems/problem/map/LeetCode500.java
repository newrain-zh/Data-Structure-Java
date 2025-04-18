package org.newrain.problems.problem.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 倒排索引
 */
public class LeetCode500 {

    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        if (docs == null || docs.isEmpty()) {
            return new HashMap<>(0);
        }
        Map<String, List<Integer>> ans = new HashMap<>();
        for (Document doc : docs) {
            String content = doc.content;
            if (content == null || content.isEmpty()) {
                continue;
            }
            String[] s = content.split(" ");
            for (String key : s) {
                if (key.isEmpty()) {
                    continue;
                }
                List<Integer> list;
                if (ans.containsKey(key)) {
                    list = ans.get(key);
                    if (list.contains(doc.id)) {
                        continue;
                    }
                } else {
                    list = new ArrayList<>();
                }
                list.add(doc.id);
                ans.put(key, list);
            }
        }
        return ans;
    }

    class Document {
        public int    id;
        public String content;
    }
}