package DP.数组区间;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 子数组最大的和 {
    public static void main(String[] args) {
        int []a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
    public static int maxSubArray(int[] nums) {
        int []dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1;i <= nums.length;i ++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1],nums[i - 1]);
        }
        int max = dp[1];
        for (int i = 1;i <= nums.length;i ++) {
            if (dp[i] > max)max = dp[i];
        }
        return max;
    }
}
