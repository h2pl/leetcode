package DP.其他问题如股票;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 需要冷却期的股票交易 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)return 0;
        if (prices.length == 2)return prices[1] - prices[0];
        if (prices.length == 3) {
            int max = prices[1] - prices[0];
            max = Math.max(prices[2] - prices[1], max);
            max = Math.max(prices[2] - prices[0], max);
            return max;
        }
        //buy at i price and sell at j price and cooldown at j + 1
        int [][]dp = new int[prices.length][prices.length];

        dp[0][1] = prices[1] - prices[0];
        for (int i = 0;i < prices.length;i ++) {
            for (int j = i + 1;j < prices.length;j ++) {
                if (i >= 3) {
                    dp[i][j] = Math.max(prices[j] - prices[i - 3],
                            dp[i - 3][j - 3] + prices[j] - prices[i]);
                }else {
                    dp[i][j] = dp[0][1];
                }
            }
        }
        for (int i = 4;i < prices.length;i ++) {
            dp[0][i] = Math.max(prices[i] - prices[0], dp[0][1] + dp[3][i]);
        }
        int max = 0;
        for (int i = 0;i < dp.length;i ++) {
            for (int j = i + 1;j < dp.length;j ++) {

            }
        }
        return max;
    }
}
