package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 统计1到n二进制1的个数 {
    public int[] countBits(int num) {
        int cnt = 0;
        int []arr = new int[num + 1];
        for (int i = 1;i <= num;i ++) {
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }
}
