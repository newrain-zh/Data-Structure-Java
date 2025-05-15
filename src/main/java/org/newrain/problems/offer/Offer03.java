package org.newrain.problems.offer;

import java.util.HashSet;
import java.util.Set;

public class Offer03 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> res = new HashSet<>(nums.length);
        for (int r : nums) {
              if (!res.isEmpty()) {
                if (res.contains(r)) {
                    return r;
                }
            }
            res.add(r);
        }
        return -1;
    }
}