package 数据结构.数组与矩阵;

/**
 * Created by 周杰伦 on 2018/4/17.
 */
public class 找出数组中最长的连续1 {
    // on
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0;i < nums.length;i ++) {
            if (nums[i] == 1) {
                count ++;
                if (count > max) {
                    max = count;
                }
            }else {
                count = 0;
            }
        }
        return max;
    }
}
