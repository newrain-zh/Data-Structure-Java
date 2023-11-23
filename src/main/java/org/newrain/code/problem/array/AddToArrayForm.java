package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author NewRain
 * @description 数组形式的整数加法
 * @link <a href="https://leetcode.cn/problems/add-to-array-form-of-integer/"></a>
 */
public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        //判断特殊情况
        List<Integer> resultList = new ArrayList<>(num.length);
        if (k == 0) {
            for (int v : num) {
                resultList.add(v);
            }
            return resultList;
        }
        //最后一位+k <=9
        if (num[num.length - 1] + k <= 9) {
            num[num.length - 1] = num[num.length - 1] + k;
            for (int v : num) {
                resultList.add(v);
            }
            return resultList;
        }
        int len = num.length;
        int lastNum = k;
        LinkedList<Integer> ret = new LinkedList<>();

        int i = len - 1;
        while (i >= 0 || lastNum > 0) {
            if (i >= 0) {
                lastNum += num[i];
            }
            ret.addFirst(lastNum % 10);
            lastNum /= 10;
            System.out.println(lastNum);
            i--;
        }
        return ret;
    }

    public static void main(String[] args) {
        //[4,5,5]
//        addToArrayForm(new int[]{2, 7, 4}, 181);
//        addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        addToArrayForm(new int[]{2, 7, 4}, 181);
    }
}