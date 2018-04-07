package DP.背包;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/6.
 */
public class 完全背包 {
    //基本解法
    //三重循环，效率低
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                for (int k = 0;k <= j/w;k ++) {
                    if (j >= k * w) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * w] + k * v);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[N][W];
    }

    //转化为01背包的解法
    //即F[i][j]=F[i][j-C[i]]+W[i]。为什么会是F[i][j-C[i]]+W[i]？
    // 因为我们前面已经最大限度的放了第i件物品,如果能放就放这最后的一件,
    //j的循环要正序，因为完全背包的第i个物品出现会影响前面的值。
    //即前面的值需要修改，以便于影响后面的值。
    public int knapsack03(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = w; j <= W; j++) {
                if (j >= w) {
                    //注意和01背包的区别,这里是dp[i][j-need[i]]+value[i]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    //优化成一维后解法 不必装满
    public int knapsack2(int W, int N, int[] weights, int[] values) {
        int[]dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = w; j <= W; j ++) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }

    //优化成一维后解法 必须装满
    public int knapsack3(int W, int N, int[] weights, int[] values) {
        int[]dp = new int[W + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = w; j <= W; j ++) {
                if (dp[j - w] != Integer.MIN_VALUE) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }
}
