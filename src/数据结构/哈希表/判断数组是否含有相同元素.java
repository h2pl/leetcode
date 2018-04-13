package 数据结构.哈希表;

import java.util.HashMap;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 判断数组是否含有相同元素 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++) {
            if (map.containsKey(nums[i])) {
                return true;
            }else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}
