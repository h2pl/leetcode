package 数学.阶乘;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 统计阶乘尾部有多少个0 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(7));
        System.out.println(trailingZeroes(13));
    }
    //暴力解法不可取
    //尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。

    //对于一个数 N，它所包含 5 的个数为：N/5 + N/52 + N/53 + ...，
    // 其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，
    // N/5^2 表示不大于 N 的数中 52 的倍数再贡献一个 5 ...。
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
//    public static int trailingZeroes(int n) {
//        String res = String.valueOf(floor(n));
//        int cnt = 0;
//        for (int i = res.length() - 1; i >= 0 ; i --) {
//            if(res.charAt(i) == '0') {
//                cnt ++;
//            }
//            else break;
//        }
//        return cnt;
//    }
//    public static long floor (int n) {
//        if (n == 1 || n == 0)return 1;
//        long []dp = new long[n + 1];
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] * i;
//        }
//        return dp[n];
//    }
}
