package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 找到仅有的两个不重复的数 {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        int []arr = new int[2];
        //取到两个不同数异或结果的最右的1。比如0001000
        res = res & (-res);
        //两个数在这个位上1个为0一个为1，异或后分别得到两个数
        for (int i : nums) {
            if ((res & i) == 0) {
                arr[0] ^= i;
            }else {
                arr[1] ^= i;
            }
        }
        return arr;
    }
}
