package org.newrain.problems.offer;

public class MissingNumber {


    public static int missingNumber(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 然后我们将中间节点设置为 ( l e f t + r i g h t ) / 2 (left + right)/2(left+right)/2
     * 如果中间节点等于数组下标，那么说明数组的 [left, mid] 是完整的，则我们需要继续查找 [mid, right]，
     * 否则我们认为 [left, mid] 是不完整的，这是我们将有指针指向 m i d − 1 mid-1mid−1 继续在 [left , mid-1]中查找。
     * ————————————————
     *
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0, 1, 2, 3, 5, 6, 7,8,9};
        System.out.println(missingNumber1(test));
    }
}