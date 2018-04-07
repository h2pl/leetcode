package DP.背包;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/6.
 */
public class 划分数组为和相等的两部分 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0)return false;
        sum = sum/2;
        //代表前i个数选出的和可以累加为j。但是i可以选择拿或不拿。
        boolean [][]dp = new boolean[nums.length + 1][sum + 1];
        for (int j = 0;j < nums.length + 1;j ++) {
            Arrays.fill(dp[j], false);
        }
        dp[0][0] = true;
        for (int i = 1;i <= nums.length;i ++) {
            for (int j = 1;j <= sum;j ++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }

}
