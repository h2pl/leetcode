package 数学.多数投票问题;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 数组中出现次数多于二分之一n的的元素 {
    public static void main(String[] args) {
        int []a = {1,3,2,2,76,2,43,2,56,1,2,2,3,3,3,12,2,2,2,2,2,2,2,};
        System.out.println(majorityElement(a));
    }
    public static int majorityElement(int[] nums) {
        if (nums.length == 0)return 0;
        if (nums.length == 1)return nums[0];
        if (nums.length == 2)return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> set = map.keySet();
        for (int i : set) {
            if (map.get(i) > n/2) {
                return i;
            }
        }
        return 0;
    }
}
