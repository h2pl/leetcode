package 数据结构.数组与矩阵;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 把数组中的0移到末尾 {
    public static void main(String[] args) {
        int []a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
    public static void moveZeroes(int[] nums){
        int index = 0;
        for (int i = 0;i < nums.length;i ++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index ++;
            }
        }
        Arrays.fill(nums,index, nums.length, 0);
    }
}
