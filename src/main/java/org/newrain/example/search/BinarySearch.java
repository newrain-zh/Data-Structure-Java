package org.newrain.example.search;

/**
 * @author newRain
 * @description 二分查找实现
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
//            mid = (low + high) / 2;
            //此处 是为了避免数组的元素过大，
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //说明数组在左侧
            if (nums[mid] > target) {
                high = mid + 1;
            } else if (nums[mid] < target) {
                low = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归写法
     *
     * @param arr
     * @param value
     * @param low
     * @param high
     * @return
     */
    public static int binarySearchByRecursion(int[] arr, int value, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low > high) {
            return -1;
        }
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return binarySearchByRecursion(arr, value, low, mid + 1);
        } else if (arr[mid] < value) {
            return binarySearchByRecursion(arr, value, low + 1, high);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        binarySearch(arr, 7);
        int result = binarySearchByRecursion(arr, 7, 0, arr.length - 1);
        System.out.println(result);
    }
}
