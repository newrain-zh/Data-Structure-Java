package org.newrain.problems.problem.base;

import java.util.ArrayList;
import java.util.List;


/**
 * leetcode.1018 可被5整除的二进制前缀
 * 一个数是否能被5整除 要看个位数是不是5
 * 给定一个二进制数组 nums ( 索引从0开始 )。
 * <p>
 * 我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。
 * <p>
 * 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
 * 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 */
public class PrefixesDivBy5 {


    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>(nums.length);
        int remainder = 0;

        for (int num : nums) {
            // 更新余数，根据当前位的值进行累加
            //乘以2：将当前的余数乘以2，相当于将二进制数向左移动一位。
            //这是因为在二进制表示中，每向左移动一位，位权重乘以2。
            //   remainder = (remainder <<1 + num) % 5;
            remainder = (remainder * 2 + num) % 5;

            // 判断当前余数是否为0，如果是则可整除，添加true；否则不可整除，添加false
            answer.add(remainder == 0);
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println( (2 * 2 + 1) % 5);
        System.out.println(((5 << 1) + 5) % 5);
    }
}