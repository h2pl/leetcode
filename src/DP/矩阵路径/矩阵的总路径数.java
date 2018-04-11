package DP.矩阵路径;

/**
 * Created by 周杰伦 on 2018/4/4.
 */
public class 矩阵的总路径数 {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for (int i = 0;i < m;i ++) {
            dp[i][0] = 1;
        }
        for (int j = 0;j < n;j ++) {
            dp[0][j] = 1;
        }

        for (int i = 1;i < m;i ++) {
            for (int j = 1;j < n;j ++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
