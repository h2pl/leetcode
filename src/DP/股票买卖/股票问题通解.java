package DP.股票买卖;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/10.
 * I -- General cases

 The idea begins with the following question: Given an array representing the price of stock on each day, what determines the maximum profit we can obtain?

 Most of you can quickly come up with answers like “it depends on which day we are and how many transactions we are allowed to complete”. Sure, those are important factors as they manifest themselves in the problem descriptions. However, there is a hidden factor that is not so obvious but vital in determining the maximum profit, which is elaborated below.

 First let’s spell out the notations to streamline our analyses. Let prices be the stock price array with length n, i denote the i-th day (i will go from 0 to n-1), k denote the maximum number of transactions allowed to complete, T[i][k] be the maximum profit that could be gained at the end of the i-th day with at most k transactions. Apparently we have base cases: T[-1][k] = T[i][0] = 0, that is, no stock or no transaction yield no profit (note the first day has i = 0 so i = -1 means no stock). Now if we can somehow relate T[i][k] to its subproblems like T[i-1][k], T[i][k-1], T[i-1][k-1], ..., we will have a working recurrence relation and the problem can be solved recursively. So how do we achieve that?

 The most straightforward way would be looking at actions taken on the i-th day. How many options do we have? The answer is three: buy, sell, rest. Which one should we take? The answer is: we don’t really know, but to find out which one is easy. We can try each option and then choose the one that maximizes our profit, provided there are no other restrictions. However, we do have an extra restriction saying no multiple transactions are allowed at the same time, meaning if we decide to buy on the i-th day, there should be 0 stock held in our hand before we buy; if we decide to sell on the i-th day, there should be exactly 1 stock held in our hand before we sell. The number of stocks held in our hand is the hidden factor mentioned above that will affect the action on the i-th day and thus affect the maximum profit.

 Therefore our definition of T[i][k] should really be split into two: T[i][k][0] and T[i][k][1], where the former denotes the maximum profit at the end of the i-th day with at most k transactions and with 0 stock in our hand AFTER taking the action, while the latter denotes the maximum profit at the end of the i-th day with at most k transactions and with 1 stock in our hand AFTER taking the action. Now the base cases and the recurrence relations can be written as:

 Base cases:
 T[-1][k][0] = 0, T[-1][k][1] = -Infinity
 T[i][0][0] = 0, T[i][0][1] = -Infinity

 Recurrence relations:
 T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
 T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])

 For the base cases, T[-1][k][0] = T[i][0][0] = 0 has the same meaning as before while T[-1][k][1] = T[i][0][1] = -Infinity emphasizes the fact that it is impossible for us to have 1 stock in hand if there is no stock available or no transactions are allowed.

 For T[i][k][0] in the recurrence relations, the actions taken on the i-th day can only be rest and sell, since we have 0 stock in our hand at the end of the day. T[i-1][k][0] is the maximum profit if action rest is taken, while T[i-1][k][1] + prices[i] is the maximum profit if action sell is taken. Note that the maximum number of allowable transactions remains the same, due to the fact that a transaction consists of two actions coming as a pair – buy and sell. Only action buy will change the maximum number of transactions allowed (well, there is actually an alternative interpretation, see my comment below).

 For T[i][k][1] in the recurrence relations, the actions taken on the i-th day can only be rest and buy, since we have 1 stock in our hand at the end of the day. T[i-1][k][1] is the maximum profit if action rest is taken, while T[i-1][k-1][0] - prices[i] is the maximum profit if action buy is taken. Note that the maximum number of allowable transactions decreases by one, since buying on the i-th day will use one transaction, as explained above.

 To find the maximum profit at the end of the last day, we can simply loop through the prices array and update T[i][k][0] and T[i][k][1] according to the recurrence relations above. The final answer will be T[i][k][0] (we always have larger profit if we end up with 0 stock in hand).

 III -- Summary

 In summary, the most general case of the stock problem can be characterized by three factors, the ordinal of the day i, the maximum number of allowable transactions k and the number of stocks in our hand at the end of the day. I have shown the recurrence relations for the maximum profits and their termination conditions, which leads to the O(nk) time and O(k) space solution. The results are then applied to each of the six cases, with the last two using slightly modified recurrence relations due to the additional requirements. I should mention that peterleetcode also introduced a nice solution here which generalizes to arbitrary k values. If you have a taste, take a look.

 Hope this helps and happy coding!
 */
public class 股票问题通解 {
    //一次交易
    public int maxProfitOnce(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;

        for (int price : prices) {
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i10;
    }
    //无限次数交易
    public int maxProfitInfinity(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return T_ik0;
    }

    //k次交易
    public int maxProfitKtimes(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE, T_i20 = 0, T_i21 = Integer.MIN_VALUE;

        for (int price : prices) {
            T_i20 = Math.max(T_i20, T_i21 + price);
            T_i21 = Math.max(T_i21, T_i10 - price);
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i20;
    }

    //k是任意的
    public int maxProfitKisArbitrary(int k, int[] prices) {
        if (k >= prices.length >>> 1) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }

        return T_ik0[k];
    }

    //有冷却时间的交易
    public int maxProfitCoolDown(int[] prices) {
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }

        return T_ik0;
    }

    //需要手续费的交易
    public int maxProfitWithFee(int[] prices, int fee) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
        }

        return T_ik0;
    }
}
