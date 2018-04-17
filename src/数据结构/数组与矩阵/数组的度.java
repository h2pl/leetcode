package 数据结构.数组与矩阵;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by 周杰伦 on 2018/4/17.
 */
public class 数组的度 {
    public static void main(String[] args) {
        int []a = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(a));
    }
    //暴力解法：
    //先找到出现次数最多的数。
    //可能有多个，对每个数求需要序列的长度。取最小值
    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (int i : set) {
            max = Math.max(map.get(i), max);
        }
        System.out.println("max:" + max);
        int min = Integer.MAX_VALUE;
        for (int x : set) {
            cnt = 0;
            int k = -1;
            for (int i = 0; i < nums.length; i++) {
                if (x == nums[i]) {
                    cnt ++;
                    if (k == -1) {
                        k = i;
                    }
                }
                if (cnt == max) {
                    min = Math.min(i - k + 1, min);
                    break;
                }
            }
        }
        return min;
    }
}
