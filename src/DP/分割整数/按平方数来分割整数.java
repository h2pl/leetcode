package DP.分割整数;

/**
 * Created by 周杰伦 on 2018/4/3.
 */
public class 按平方数来分割整数 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));

    }
    //dp[1] = 1;
    //dp[2] = 2;
    //dp[3] = 3;
    //dp[4] = 1;dp[5] = 2 dp[6] = 3 dp[7]=4 dp[8]=2 dp[9]=3 dp[10]=2 dp[11]=3 dp[12] = 3
    //dp[i] = dp[i-j] + per
    //dp[i] = dp[i-1] + 1;huozhe dp[i-j] + which i-j = perfect
    public static int numSquares(int n) {
        int []dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 0;
        for (int k = 2;k <= n;k ++) {
            dp[k] = k;
        }

        for (int i = 2;i <= n;i ++) {
            int j = 1;
            int min = dp[i];
            while (i - j*j >= 0 ) {
                min = Math.min(min,dp[i - j*j] + 1);
                j ++;
            }
            dp[i] = min;
        }

        return dp[n];
    }
    public static boolean isPerfect(int n) {
        if (Math.pow(n,0.5) - Math.ceil(Math.pow(n,0.5)) == 0) {
            return true;
        }
        return false;
    }
}
