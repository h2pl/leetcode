package DP.背包.字符串;

/**
 * Created by 周杰伦 on 2018/4/8.
 */
public class 字符01构成最多的字符串 {
    public static void main(String[] args) {
        String []a = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(a, 5, 3));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        //代表i个0和j个1能够成最多的字符串个数
        //首先写出矩阵
        int [][]dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        //然后根据条件写一个商品的for循环
        for (String str : strs) {
            int needZero = 0;
            int needOne = 0;
            //再根据条件写费用的循环。
            //可能是二维费用，则有两个循环。多重背包也类似
            //如果是完全背包，则用顺序，01背包用逆序。

            //该步相当于计算放入第i件物品所需的费用。
            //因为是二维的，所以类比到01背包，在背包中就是重量和体积
            for (int i = 0;i < str.length();i ++) {
                if (str.charAt(i) == '0')needZero ++;
                else needOne ++;
            }
            for (int j = m;j >= needZero;j --) {
                for (int k = n;k >= needOne;k --) {
                    dp[j][k] = Math.max(dp[j - needZero][k - needOne] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}
