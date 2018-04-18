package 数据结构.数组与矩阵;

import java.util.ArrayList;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 找出数组中重复的数有条件限制 {
    public int findDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int []arr = new int[nums.length + 1];
        for (int i = 0;i < nums.length;i ++) {
            if (arr[nums[i]] == 0) {
                arr[nums[i]] = 1;
            }else {
                arr[nums[i]] ++;
            }
        }
        for (int i = 1;i < arr.length;i ++) {
            if (arr[i] > 1) {
                return i;
            }
        }
        return 0;
    }
}
