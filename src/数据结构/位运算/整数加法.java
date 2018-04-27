package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 整数加法 {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
}
