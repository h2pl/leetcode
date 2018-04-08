package DP.背包.背包扩展;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/8.
 */
public class 组合总和 {
    static int count = 0;
    public static void main(String[] args) {
        int []a = {1,2,3};
        System.out.println(combinationSum(a, 32));
    }
    //dfs会超时，当target较大时直接超时
    public static int combinationSum4(int[] nums, int target) {
        count = 0;
        dfs(0, nums, target);
        return count;
    }
    public static void dfs(int sum, int []nums, int target) {
        if (sum == target) {
            count ++;
            return;
        }
        else if (sum > target)return;

        for (int i = 0;i < nums.length;i ++) {
            dfs(sum + nums[i],nums,target);
        }
        return;
    }


    //dp求解 完全背包
    public static int combinationSum(int[] nums, int target) {
        int []dp = new int[target + 1];
        //这句不对，虽然是要求装满，但是只有求最大值或最小值的时候才需要设置。
        // 求使用物品总数，使用物品组成的不同序列的总数等问题时不用设置。
        //具体问题具体分析
//        Arrays.fill(dp, Integer.MIN_VALUE);
        //此处变通一下，dp[0] = 1，而不是dp[0] = 0,否则所有值都为0了
        //至于为什么，暂时不知道
        //因为dp[1] = dp[0] + dp[1]当数组里有1时，dp[1] = 1.
        //为了满足此要求，dp[0] = 1;同理，当j = num[i]时，至少都有一种解。
        dp[0] = 1;
        for (int j = 1;j <= target;j ++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i] ) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];

    }

}
