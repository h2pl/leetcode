package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 数组中唯一一个不重复的元素 {
    public int singleNumber(int[] nums) {
        int res = 0;
        //相同的元素异或得0,0和唯一的一个元素异或得到该元素
        for (int i : nums) {
            res = res ^ i;
        }
        return res;
    }
}
