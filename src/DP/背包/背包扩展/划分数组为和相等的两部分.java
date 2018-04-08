package DP.背包.背包扩展;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/6.
 */
public class 划分数组为和相等的两部分 {
    public static void main(String[] args) {
        int []a = {1, 5, 11, 5};
        System.out.println(canPartition2(a));
    }
    //优化版
    //本题的背包重量就是和的一半。
    //每个数都是一个物品的费用。
    //于是得dp[i] = dp[i - num[i]] || dp[i]
    //由于本题是判断能否加到一个和，所以只判断true和false
    //如果是凑成的数量就是 + 1，如果是价值就是加v[i]
    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0)return false;
        sum = sum/2;
        //代表前i个数选出的和可以累加为j。但是i可以选择拿或不拿。
        boolean []dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0;i < nums.length;i ++) {
            for (int j = sum;j >= nums[i];j --) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }


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
