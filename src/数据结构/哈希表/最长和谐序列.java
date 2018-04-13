package 数据结构.哈希表;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 最长和谐序列 {
    public static void main(String[] args) {
        int []a = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(a));
    }

    public static int findLHS(int[] nums) {
        int cnt = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i ++) {
            if (map.containsKey(nums[i])) {
                cnt ++;
            }else {
                map.put(nums[i], i);
                if (map.containsKey(nums[i] - 1) || map.containsKey(nums[i] + 1)) {
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
