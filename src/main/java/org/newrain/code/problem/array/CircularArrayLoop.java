package org.newrain.code.problem.array;


/**
 * leetcode.457 环形数组是否存在循环·
 *
 * 存在一个不含 0 的 环形 数组 nums ，
 * <p>
 * 每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * <p>
 * 如果 nums[i] 是正数，向前（下标递增方向）移动 |nums[i]| 步
 * <p>
 * 如果 nums[i] 是负数，向后（下标递减方向）移动 |nums[i]| 步
 * <p>
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，
 * 而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq 标识：
 * <p>
 * 遵循上述移动规则将导致一组重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 */
public class CircularArrayLoop {


    public static boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = getNext(nums, i);
            //按照题意循环数组里的元素 要么全是整数 要么全是负数
            while (nums[fast] * nums[slow] > 0 && nums[getNext(nums, fast)] * nums[slow] > 0) {
                if (fast == slow) {
                    if (slow != getNext(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
            }

        }
        return false;
    }

    /**
     * 核心方法
     * 根据当前数组的值计算出移动到下个地址的数组位置
     *
     * @param nums    需要遍历的数组
     * @param current 当前位置
     * @return 遍历的位置
     */
    public static int getNext(int[] nums, int current) {
        int n = nums.length;
        //current + nums[current] 计算下一步移动的位置
        //如果 nums[current] 是正数，这意味着向前（索引递增方向）移动 nums[current] 步。
        //如果 nums[current] 是负数，则向后（索引递减方向）移动 |nums[current]| 步。
        //% n
        //第一次使用 % n 是为了处理越界情况。
        //如果计算的新位置超出了数组的上界（即大于等于 n），这个操作会将其环绕回数组的开始。
        //如果计算的新位置小于 0（即向后移动时跨过数组的开始），
        //这个操作会得到一个负数。这不是一个有效的索引，因此我们需要进一步处理。
        //+n
        //这部分处理了当新计算的位置为负数时的情况。加上数组长度 n 可以确保结果是一个正数。
        //第二次 % n:
        //最后再次使用 % n 是为了从负索引环绕回数组的末尾。
        //由于在前面我们添加了 n，这一步确保了结果始终在 0 到 n-1 的范围内
        return ((current + nums[current]) % n + n) % n;
    }

    public static boolean circularArrayLoop1(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = i;
            int next = next(nums, curr);
            if (curr == next) {
                continue;
            }
            while (true) {
                if (nums[curr] * nums[next] > 0) {
                    len++;
                }
                if (curr == next) {
                    break;
                }
                if (next >= nums.length - 1) {
                    break;
                }
                curr = next;
                next = next(nums, next);
            }
            if (len > 1) {
                return true;
            }
            len = 0;
        }
        return false;
    }


    public static int next(int[] nums, int p) {
        if (p > nums.length - 1) {
            return 0;
        }
        if (nums[p] < 0) {//为负数的情况 需要向左遍历
            //[2,-3,1,2,2]
            //先计算出数组向左能遍历多少位
            int p1 = p - Math.abs(nums[p]);
            if (p1 >= 0) { //
                return p1;
            }
            //从数组后面向前遍历位置
            return nums.length - Math.abs(p1);
        }
        //向右移位已经超出数组的长度限制
        int p1 = p + nums[p];
        return p1 > nums.length - 1 ? p1 - nums.length : p1;
    }

    public static void main(String[] args) {
        System.out.println(getNext(new int[]{2, -1, 1, 2, 2}, 3));
        System.out.println(next(new int[]{2, -1, 1, 2, 2}, 3));
//        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
    }
}