package org.newrain.leetcode.problem.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author newrain
 */
public class LeetCode121 {

    /**
     * 如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
     *记录【今天之前买入的最小值】
     * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
     * 比较【每天的最大获利】，取最大值即可
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //将第一天的够买股票的价格假设为最低价
        int minPrice = prices[0];
        //保存最大差价的变量
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            //卖出的价格要大于买入的价格
            //即前面的数字小于的数字
            //如果今天的买入价格小于昨天的价格 最小值更改为今日的价格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static int maxProfit1(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            //记录每天的最小值 今天的价格和之前的最低价格谁最低
            minPrice = Math.min(minPrice, prices[i]);
            //然后用今天的价格和低价比得取差值
            int currDeff = prices[i] - minPrice;
            //然后比较差值哪个最大
            maxProfit = Math.max(maxProfit, currDeff);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] params = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(params));
        System.out.println(maxProfit1(params));


    }
}
