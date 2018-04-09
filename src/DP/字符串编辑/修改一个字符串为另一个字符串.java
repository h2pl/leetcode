package DP.字符串编辑;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 修改一个字符串为另一个字符串 {
    public int minDistance(String word1, String word2) {
        if (word1.equals("") && word2.equals(""))return 0;
        int m = word1.length();
        int n = word2.length();
        //把word1的前i个字符变成word2的前j个字符。
        int [][]dp = new int[m + 1][n + 1];
        for (int i = 1;i <= m;i ++) {
            dp[i][0] = i;
        }
        for (int j = 1;j <= n;j ++) {
            dp[0][j] = j;
        }
        dp[0][0] = 0;
        for (int i = 1;i <= m;i ++) {
            for (int j = 1;j <= n;j ++) {
                int c1 = dp[i][j - 1] + 1;
                int c2 = dp[i - 1][j] + 1;
                int c3 = dp[i - 1][j - 1] + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    c3 = dp[i - 1][j - 1];
                }
                int min = Math.min(Math.min(c1, c2), c3);
                dp[i][j] = min;
            }
        }
        return dp[m][n];
    }
}
