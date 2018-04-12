package 数学.素数;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/5.
 * 素数

 素数分解

 每一个数都可以分解成素数的乘积，例如 84 = 22 * 31 * 50 * 71 * 110 * 130 * 170 * …

 整除

 令 x = 2m0 * 3m1 * 5m2 * 7m3 * 11m4 * … 令 y = 2n0 * 3n1 * 5n2 * 7n3 * 11n4 * …

 如果 x 整除 y（y mod x == 0），则对于所有 i，mi <= ni。

 x 和 y 的 最大公约数 为：gcd(x,y) = 2min(m0,n0) * 3min(m1,n1) * 5min(m2,n2) * ...

 x 和 y 的 最小公倍数 为：lcm(x,y) = 2max(m0,n0) * 3max(m1,n1) * 5max(m2,n2) * ...
 */
public class 生成素数序列 {
    public static void main(String[] args) {

        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        boolean []prime = new boolean[n];
        Arrays.fill(prime, true);
        int count = 0;
        for (int i = 2;i < n;i ++) {
            if (prime[i] == true) {
                count ++;
            }
            for (int j = 2;i * j < n;j ++) {
                prime[i * j] = false;
            }
        }
        return count;
    }

}
