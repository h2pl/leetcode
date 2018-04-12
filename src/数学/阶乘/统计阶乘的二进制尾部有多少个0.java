package 数学.阶乘;

/**
 * Created by 周杰伦 on 2018/4/12.
 * 如果统计的是 N! 的二进制表示中最低位 1 的位置，只要统计有多少个 2 即可，该题目出自 编程之美：2.2 。
 * 和求解有多少个 5 一样，2 的个数为 N/2 + N/22 + N/23 + ...
 */
public class 统计阶乘的二进制尾部有多少个0 {
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 2 + trailingZeroes(n / 2);
    }
}
