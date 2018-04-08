package DP.背包;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/7.
 */
public class 多重背包 {
    //首先是正规解法，和完全背包类似。
    //多重背包限制了每个物品的数量，介于01和完全背包之间。
    public static int knapsack(int W, int N, int[] weights, int[] values, int []nums) {
        int[][] dp = new int[N + 1][W + 1];
        //物品数为0时，取法初始化为0，代表不能装满，但是可以进行累加。因为不需要装满。
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = w; j <= W; j++) {
                for (int k = 1;k <= nums[i];i ++) {
                    if (j >= k * w) {
                        // 那只是一种理解方法，其实正规的应该是这样的
                        // dp[i][j] = max ( dp[i-1][j - k*weight[i]] +k*value[i] )0<=k<=nums[i]
                        // （这个跟完全背包差点就一毛一样了啊喂|||- -）
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * w] + k * v);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[N][W];
    }

    //根据01背包进行优化
    //首先这种可以把物品拆开，把相同的num[i]件物品 看成
    // 价值跟重量相同的num[i]件不同的物品，那么！！
    // 是不是就转化成了一个规模稍微大一点的01背包了。对不对！！对不对！！
    public static int knapsack2(int W, int N, int[] weights, int[] values, int []nums) {
        int []dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            //其实就是把这类物品展开，调用num[i]次01背包代码
            for (int k = 1;k <= nums[i];k ++) {
                for (int j = W; j >= w; j--) {
                    ////正常的01背包代码
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }

    //最优化的多重背包。
    //第i件物品若满足总数*重量小于背包重量，即可用完全背包来解。
    //若不满足，则按照1 2 4的二进制速度上升。复杂度为log2n
    int Multi_Pack(int wegihts[],int values[],int nums[],int N,int W)//多重背包
    {
        int []dp = new int[N + 1];
        for(int i=1; i<=N; i++)//遍历每种物品
        {
            if(nums[i]*wegihts[i] > W)
                Complete_Pack(wegihts[i],values[i],W,dp);
                //如果全装进去已经超了重量，相当于这个物品就是无限的
                //因为是取不光的。那么就用完全背包去套
            else
            {
                int k = 1;
                //取得光的话，去遍历每种取法
                //这里用到是二进制思想，降低了复杂度
                //为什么呢，因为他取的1,2,4,8...与余数个该物品，打包成一个大型的该物品
                //这样足够凑出了从0-k个该物品取法
                //把复杂度从k变成了logk
                //如k=11，则有1,2,4,4，足够凑出0-11个该物品的取法
                while(k < nums[i])
                {
                    ZeroOne_Pack(k*wegihts[i],k*values[i],W,dp);
                    nums[i] -= k;
                    k <<= 1;
                }
                //如果这一次装k个的空间不够了，就把该价值剩下的物品装进去
                ZeroOne_Pack(nums[i]*wegihts[i],nums[i]*values[i],W,dp);
            }
        }
        return dp[W];
    }

    void ZeroOne_Pack(int weight,int value,int W,int []dp)//吧01背包封装成函数
    {
        for(int i=W; i>=weight; i--)
            dp[i] = Math.max(dp[i],dp[i-weight] + value);
    }

    void Complete_Pack(int weight,int value,int W,int []dp)//把完全背包封装成函数
    {
        for(int i=weight; i<=W; i++)
            dp[i] = Math.max(dp[i],dp[i-weight] + value);
    }



}
