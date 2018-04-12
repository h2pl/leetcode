package 贪心;

/**
 * Created by 周杰伦 on 2018/3/17.
 */
public class 买卖股票 {
    public int maxProfit(int[] prices) {
        if(prices.length <=1){
            return 0;
        }
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }

        }
        return profit;
    }
}
