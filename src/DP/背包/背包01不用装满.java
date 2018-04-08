package DP.背包;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/6.
 */
public class 背包01不用装满 {
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
        //不用装满就设为0，需要装满的话，求最大值时设为负无穷，求最小值时设为正无穷。
        //物品数为0时，取法初始化为0，代表不能装满，但是可以进行累加。因为不需要装满。
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    // 优化一维 只对一维有这个要求
    //01背包每个物品只装一次，所以后面的结果不影响前面的结果。j应该逆序来算。
    //如果正序来算，后面的循环中可能会修改前面的值，这是不被允许的，因为一个物品只放一次。
    //后面的循环是不能改前面的值的。
    public static int knapsack2(int W, int N, int[] weights, int[] values) {
        int []dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = W; j >= w; j --) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        return dp[W];
    }
}
