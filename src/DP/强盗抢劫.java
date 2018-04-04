package DP;

/**
 * Created by 周杰伦 on 2018/4/4.
 */
public class 强盗抢劫 {
    public static void main(String[] args) {
        int []a = {1,3,5,7,2};
        int []b = {2,6,9,1};
        System.out.println(rob(a));
        System.out.println(rob(b));
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2)return nums[0] > nums[1] ? nums[0] : nums[1];
        int []dp = new int[nums.length + 1];
        //dp代表最右只抢到第n家时的总钱数。
        dp[1] = nums[0];
        dp[2] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 3;i <= nums.length;i ++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }
}
