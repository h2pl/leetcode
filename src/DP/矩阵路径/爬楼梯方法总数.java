package DP.矩阵路径;

/**
 * Created by 周杰伦 on 2018/4/4.
 */
public class 爬楼梯方法总数 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)return n;
        int []dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3;i <= n;i ++ ) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
