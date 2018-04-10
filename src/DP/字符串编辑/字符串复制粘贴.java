package DP.字符串编辑;

/**
 * Created by 周杰伦 on 2018/4/10.
 */
public class 字符串复制粘贴 {
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }

            }
        }
        return dp[n];
    }
}
