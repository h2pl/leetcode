package DP.背包;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/7.
 */
public class 背包01需要装满 {
    public static void main(String[] args) {
        int N = 3;
        int W = 10;
        int w[] = {3, 4, 5};
        int v[] = {4, 5, 6};
        System.out.println(knapsack(W,N,w,v));
        System.out.println(knapsack2(W,N,w,v));
    }
    public static int knapsack(int W, int N, int[] weights, int[] values) {

        int[][] dp = new int[N + 1][W + 1];
        //前0个物品永远无法装满1-W重量的背包。置为负无穷，dp累加时只考虑前面已经装满的清空。
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        //前0个物品刚好可以装满容量为0的背包，此时价值为0，以此为初始值进行累加。
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = w; j <= W; j++) {
                if (j >= w && dp[i - 1][j - w] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
            }
        }
        return dp[N][W];
    }

    // 优化一维
    public static int knapsack2(int W, int N, int[] weights, int[] values) {
        int []dp = new int[W + 1];
        //前0个物品永远无法装满1-W重量的背包。置为负无穷，dp累加时只考虑前面已经装满的情况。
        Arrays.fill(dp, Integer.MIN_VALUE);
        //前0个物品刚好可以装满容量为0的背包，此时价值为0，以此为初始值进行累加。
        dp[0]= 0;
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = W; j >= w; j --) {
                if (dp[j - w] != Integer.MIN_VALUE) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }}
        }
        return dp[W];
    }
}
