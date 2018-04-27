package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 一个数是否为4的n次方 {

    public boolean isPowerOfFour(int num) {
        if (num < 0) return false;
        //保证这个数只有1个1并且1后面只有偶数个0，也就是1在奇数位上
        if (Integer.bitCount(num) == 1 && Integer.numberOfTrailingZeros(num) % 2 == 0) {
            return true;
        }
        return false;
    }
}
