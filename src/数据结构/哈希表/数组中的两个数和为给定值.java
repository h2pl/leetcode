package 数据结构.哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 数组中的两个数和为给定值 {
    public static void main(String[] args) {
        int []a = {3,2,4};
        System.out.println(Arrays.toString(twoSum(a, 6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int []two = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++) {
            map.put(nums[i],i);
        }
        for (int i = 0;i < nums.length;i ++) {
            if (map.containsKey(target - nums[i])) {
                if (i == map.get(target - nums[i])) {
                    continue;
                }
                two[0] = i;
                two[1] = map.get(target - nums[i]);
                return two;
            }
        }
        return two;
    }
}
