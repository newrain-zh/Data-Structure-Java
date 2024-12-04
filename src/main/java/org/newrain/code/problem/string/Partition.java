package org.newrain.code.problem.string;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> ans;
        if (s.length() == 1) {
            ans = new ArrayList<>(1);
            List<String> list = new ArrayList<>(1);
            list.add(s);
            ans.add(list);
            return ans;
        }
        //
        return null;
    }
}