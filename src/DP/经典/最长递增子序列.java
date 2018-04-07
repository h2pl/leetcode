package DP.经典;

/**
 * Created by 周杰伦 on 2018/4/4.
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int []a = {10,9,2,5,3,4};
        int []b = {10, 9, 2, 5, 3, 7, 101, 18};
        int []c = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLIS(b));
        System.out.println(lengthOfLIS(c));
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        if (nums.length == 1)return 1;
        int []dp = new int[nums.length];
        dp[0] = 1;
        //int []c = {4,10,4,3,8,9};
        for (int i = 1;i < nums.length;i ++) {
            int max = 1;
            for (int j = 0;j < i;j ++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
                dp[i] = max;
            }
        }
        int max = 0;
        for (int i = 0;i < nums.length;i ++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
