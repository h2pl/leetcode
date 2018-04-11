package DP.股票买卖;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 需要冷却期的股票交易_双数组 {
    public static void main(String[] args) {
        int []a = {6,1,3,2,4,7};
        System.out.println(maxProfit(a));
    }

    //错误的解法。
//    public static int maxProfit(int[] prices) {
//        if (prices.length < 2) return 0;
//        int[] sell = new int[prices.length];
//        int []cool = new int[prices.length];
//        int []buy = new int[prices.length];
//        sell[0] = Integer.MIN_VALUE;
//        sell[1] = prices[1] - prices[0];
//        cool[0] = Integer.MIN_VALUE;
//        cool[1] = Integer.MIN_VALUE;
//        buy[0] = - prices[0];
//        buy[1] = - prices[1];
//        for (int i = 2;i < prices.length;i ++) {
//            //buy[i] = cool[i - 1]
//            buy[i] = cool[i - 1];
//            sell[i] = Math.max(sell[i - 1] + prices[i] - prices[i - 1]  ,buy[i - 1] + prices[i]);
//            cool[i] = Math.max(cool[i - 1], sell[i - 1]);
//        }
//        int max = Math.max(sell[prices.length - 1], cool[prices.length - 1]);
//        return max;
//    }


    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[len]; //sell[i] means must sell at day i
        int[] cooldown = new int[len]; //cooldown[i] means day i is cooldown day
        sell[1] = prices[1] - prices[0];
        for(int i = 2; i < prices.length; ++i){
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
            sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], cooldown[i - 2]);
        }
        return Math.max(sell[len - 1], cooldown[len - 1]);
    }
}
