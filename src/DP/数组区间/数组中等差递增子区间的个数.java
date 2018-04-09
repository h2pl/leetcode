package DP.数组区间;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 数组中等差递增子区间的个数 {
    //首先找规律。3个等差数字 dp[3] = 1 .dp[4] = 4个数和后面3个数=2.
    //dp[5] = 前五个数 2345 345 = 3.可得dp[i] = dp[i - 1] + 1;
    public static void main(String[] args) {

    }
    public int numberOfArithmeticSlices(int[] A) {
        int []dp = new int[A.length];
        for (int i = 2;i < A.length;i ++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                //此处的初值为1，接下来的推导都是正确的。
                dp[i] = dp[i - 1] + 1;
            }
        }
        int res = 0;
        //算出总的方法数。妙啊
        for (int cnt : dp) {
            res += cnt;
        }
        return res;
    }

// dfs行不通
// static int count = 0;
//    public int numberOfArithmeticSlices(int[] A) {
//        for (int i = 2;i < A.length;i ++) {
//            dfs(A, i,true, 0);
//        }
//        return count;
//    }
//    public void dfs(int []A, int cur, boolean flag, int diff) {
//        if (flag && cur <= A.length) {
//            count ++;
//            return;
//        }
//        if (A[cur + 1] - A[cur] == A[cur + 2] - A[cur + 1] ) {
//            flag = true;
//            diff = A[cur + 2] - A[cur + 1]
//        }
//    }
}
