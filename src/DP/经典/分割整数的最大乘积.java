package DP.经典;

/**
 * Created by 周杰伦 on 2018/4/3.
 */
public class 分割整数的最大乘积 {
    //2 = 1+1 1 /3 2+1 2/4 2+2 4/5 2+3 6/6 3+3 9
    // /7 3 2 2 12/8 = 3+3+2 18/9 = 3+3+3 27/10 = 3+3+4 36
    //dp[0] = 0 dp[1] = 0 dp[2] = 1; dp[3] = dp[2] + i - 1
    //dp[i] = dp[i-1]
    public int integerBreak(int n) {
        int []dp = new int[n + 1];
        dp[1] = 0;
        //dp[i]代表以以i为结尾的最大乘积。
        for (int i = 2;i <=n;i ++) {
            for (int j = 1;j < i;j ++) {
                //这一部是将n分成i和j两个数，要么取j要么取j分成的数。
                //要么取i-j要么取i-j拆分成的数，谁大就取谁。
                //再将这两部分相乘。并且dp是从左往右算的，可以保证有序。
                dp[i] = Math.max(dp[i],Math.max(j,dp[j])*Math.max(i - j,dp[i - j]));
            }
        }
        return dp[n];
    }
}
