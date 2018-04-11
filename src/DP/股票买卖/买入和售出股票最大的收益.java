package DP.股票买卖;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 买入和售出股票最大的收益 {
    public static void main(String[] args) {
        int []a = {7, 1, 5, 3, 6, 4};
        int []b = {3,2,6,5,0,3};
        System.out.println(maxProfit(a));
        System.out.println(maxProfit(b));

    }
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;
        for (int v : prices) {
            lowest = Math.min(v, lowest);
            maxProfit = Math.max(maxProfit, v - lowest);
        }
        return maxProfit;
    }
    //时间复杂度过大
//    public static int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 1;i < prices.length;i ++) {
//            for (int j = 0;j < i;j ++) {
//                if (prices[i] - prices[j] > max)max = prices[i] - prices[j];
//            }
//        }
//        return max;
//    }

    //解法太复杂
//    public static int maxProfit(int[] prices) {
//        if (prices.length == 0)return 0;
//        int []dp = new int[prices.length];
//        dp[0] = 0;
//        int []mins = new int[prices.length];
//        mins[0] = prices[0];
//        for (int i = 1;i < prices.length;i ++) {
//            if (prices[i] < mins[i - 1]) {
//                mins[i] = prices[i];
//            }else {
//                mins[i] = mins[i - 1];
//            }
//        }
//        for (int i = 1;i < prices.length;i ++) {
//            int min = mins[i];
//            if (prices[i] > min && prices[i] > prices[i - 1]) {
//                dp[i] = Math.max(prices[i] - min, dp[i - 1]);
//            }else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[prices.length - 1];
//    }
}
