package DP.背包;

/**
 * Created by 周杰伦 on 2018/4/8.
 */
public class 多维费用的背包 {
    //是01背包的延伸，费用变成了2维
    //接下来的注释是背包问题的一般解法
    public static int knapsack2(int W1,int W2, int N, int[][] weights, int[] values) {
        int [][]dp = new int[W1 + 1][W2 + 1];
        for (int i = 1; i <= N; i++) {
            int w1 = weights[i - 1][0],w2 = weights[i - 1][1], v = values[i - 1];
            for (int j = W1; j >= w1;j --) {
                for (int k = W2;j >= w2;k -- )
                dp[j][k] = Math.max(dp[j][k], dp[j - w1][k - w2] + v);
            }
        }
        return dp[W1][W2];
    }
}
