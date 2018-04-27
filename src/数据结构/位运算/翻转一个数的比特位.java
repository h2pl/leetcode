package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 翻转一个数的比特位 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= (n & 1);
            n >>>= 1;
        }
        return ret;
    }
}
