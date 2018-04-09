package DP.分割整数;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 按平方数来分割整数自写 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        int []dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2;i <= n;i ++) {
            //默认等于前一位+1
            dp[i] = dp[i - 1] + 1;
            if (isSquare(i)) {
                dp[i] = 1;
                continue;
            }
            //当差为平方数时直接 等于其+1即可。这样的时间复杂度大大降低。
            //为onlogn.否则是on2不符合要求
            for (int j = 1;j * j < i;j ++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    public static boolean isSquare(int n) {
        if (Math.ceil(Math.pow(n,0.5)) == Math.pow(n,0.5)) {
            return true;
        }
        return false;
    }
}
