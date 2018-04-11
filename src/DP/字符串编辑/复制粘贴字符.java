package DP.字符串编辑;

/**
 * Created by 周杰伦 on 2018/4/11.
 */
public class 复制粘贴字符 {
    public static void main(String[] args) {
        System.out.println(minSteps(3));
        System.out.println(minSteps(4));
        System.out.println(minSteps(5));
        System.out.println(minSteps(6));
        System.out.println(minSteps(7));
        System.out.println(minSteps(8));
    }
    public static int minSteps(int n) {
        if (n == 1) return 0;
        int []dp = new int[n + 1];
        dp[1] = 1;
        //dp[2] = 2;
        //dp[3] = 3;
        //dp[4] = 4; dp[5] = 5;dp[6] = 5;dp[7] = 7;dp[8] = 6;

        for (int i = 2;i <= n;i ++) {
            dp[i] = i;
            for (int j = 1;j < i;j ++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + ((i/j)));
                }
            }
        }
        return dp[n];
    }
}
