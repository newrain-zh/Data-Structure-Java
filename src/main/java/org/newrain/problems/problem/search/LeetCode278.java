package org.newrain.problems.problem.search;

/**
 * LeetCode.278 第一个错误的版本
 */
public class LeetCode278 {


    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean isBadVersion(int version) {
        if (version == 4) {
            return true;
        }
        return false;
    }
}