package DP.背包.背包扩展;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/8.
 */
public class 找零钱 {
    public static void main(String[] args) {
        int []coins = {1, 2, 5};
        System.out.println(coinChange(coins,11));
    }
    //是完全背包问题
    //无限的硬币凑成一个数
    //要求硬币最少，求的是最小值，于是把不符合要求的位置置为正最大。
    //类比于背包求最大价值时把不符合要求的位置设为负最大。就是避免经过这些位置。
    public static int coinChange(int[] coins, int amount) {
        int[]dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1;i <= amount;i ++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
