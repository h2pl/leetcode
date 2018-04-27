package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 不用额外变量交换两个整数 {
    public void swap (int a,int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }
}
