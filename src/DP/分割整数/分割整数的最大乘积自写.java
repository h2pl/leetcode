package DP.分割整数;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 分割整数的最大乘积自写 {
    // 2 = 1+1 3 = 1+2 4=2+2 5=2+3 6=3+3
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n) {
        if (n == 1 || n == 0)return 0;
        int []dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3;i <= n;i ++) {
            for (int j = 1;j < i;j ++ ) {
                dp[i] = Math.max(dp[i],dp[j] * (i - j));
                if ((i-j) * j > dp[i] ) dp[i] = (i - j) * j;
            }
        }
        return dp[n];
    }
}
