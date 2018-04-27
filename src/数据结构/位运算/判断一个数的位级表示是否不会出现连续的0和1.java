package 数据结构.位运算;

import java.lang.reflect.Parameter;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 判断一个数的位级表示是否不会出现连续的0和1{
    public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            if (((n >> 1) & 1) == (n & 1)) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}
