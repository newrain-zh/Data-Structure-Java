package org.newrain.problems.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 */
public class LeetCode560 {

    /**
     * ❌错误解法
     */
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];
            if (diff == 0) {
                ans++;
                break;
            } else if (diff > 0) {
                int start = i + 1;
                while (start < nums.length) {
                    if (diff - nums[start] == 0) {
                        ans++;
                        break;
                    } else if (diff - nums[start] < 0) {
                        break;
                    }
                    start++;
                }
            }
        }
        return ans;
    }


    public static int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int                   sum = 0;
        int                   ans = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        map.forEach((k1, v) -> {
            System.out.println(k1 + "," + v);
        });
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{1, 1, 1}, 2)); // 2
//        System.out.println(subarraySum(new int[]{1, 2, 3}, 3)); // 2
        // 1,1,1,2,2
        System.out.println(subarraySum1(new int[]{1, 2, 1, 2, 1}, 3)); // 4
    }
}