package DP;

/**
 * Created by 周杰伦 on 2018/4/4.
 */
public class 强盗在环形街区抢劫 {
    public static void main(String[] args) {
        int []a = {1,2};
        int []b = {1,2,3};
        int []c = {1,3,2,4};
        int []d = {6,4,2,5,9};
        System.out.println(rob(a));
        System.out.println(rob(b));
        System.out.println(rob(c));
        System.out.println(rob(d));
    }
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2)return nums[0] > nums[1] ? nums[0] : nums[1];
        int []dp = new int[nums.length + 1];
        //dp代表最右只抢到第n家时的总钱数。
        //如果抢了第一家
        dp[1] = nums[0];
        dp[2] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 3;i < nums.length;i ++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        int max = dp[nums.length - 1];
        //如果不抢第一家
        dp[1] = 0;
        dp[2] = nums[1];
        for (int i = 3;i <= nums.length;i ++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        if (dp[nums.length]  > max)max = dp[nums.length];
        return max;
    }
}
