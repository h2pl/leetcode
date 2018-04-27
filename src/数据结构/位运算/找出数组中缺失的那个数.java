package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 找出数组中缺失的那个数 {
    //和找唯一数一样的思路，数组中的数全部异或，再和1-n的所有数异或。
    //最后的结果就是缺少的那个数
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        for (int i = 0;i <= n;i ++) {
            res = res ^ i;
        }
        return res;
    }
}
