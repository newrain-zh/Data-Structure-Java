package org.newrain.code.offer;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        //最大利润
        int maxProfit = 0;
        //历史最小价格
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            //获取今天价格是否是历史最低价
            min = Math.min(price, min);
            //获取今天的价格减去历史最低价得到最大利润
            maxProfit = Math.max(price - min, maxProfit);
        }
        return maxProfit;
    }

    /**
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        //记录每次卖出的价格
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    /**
     * leetCode714
     * 买卖股票的最佳时机含手续费
     * 贪心算法
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfitByFee(int[] prices, int fee) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        //初始化购买股票的价格=第一天的价格加上手续费
        int buy = prices[0] + fee;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            //如果今天的价格为最低价格 就更新购买的最低价格
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
                //如果今天的价格大于购买的价格就出售获取利润 和更新buy的价格
            } else if (prices[i] > buy) {
                max += prices[i] - buy;
                buy = prices[i];
            }
        }
        return max;
    }

    /**
     * 最佳买卖股票时机含冷冻期
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit2(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfitByFee(new int[]{1, 3, 2, 8, 4, 9}, 3));
    }

}
