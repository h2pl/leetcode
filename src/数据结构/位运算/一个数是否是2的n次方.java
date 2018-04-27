package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 一个数是否是2的n次方 {
    //2的n次方的二进制表示只有1个1
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        if (Integer.bitCount(n) == 1) {
            return true;
        }return false;
    }
//    利用 1000 & 0111 == 0 这种性质，得到以下解法：
//
//    public boolean isPowerOfTwo(int n) {
//        return n > 0 && (n & (n - 1)) == 0;
//    }
}
