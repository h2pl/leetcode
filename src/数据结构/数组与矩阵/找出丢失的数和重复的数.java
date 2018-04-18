package 数据结构.数组与矩阵;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 找出丢失的数和重复的数 {
    public static void main(String[] args) {
        int []a = {1,5,3,2,2,7,6,4,8,9};
        //[1,5,3,2,2,7,6,4,8,9]
        int []b = {3,2,3,4,6,5};
        //[3,2,3,4,6,5]
        //233456
        System.out.println(Arrays.toString(findErrorNums(b)));
        //1223456789
        //233456
        //1234556
        System.out.println(Arrays.toString(findErrorNums(a)));
    }
    //先找重复，再找丢失
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int []arr = new int[2];
        int r = 0;
        for (int i = 0;i < nums.length - 1;i ++) {
            if (nums[i] == nums[i + 1]) {
                arr[0] = nums[i];
                r = i;
                break;
            }
        }
        for (int i = 0;i <= r;i ++) {
            if (i + 1 != nums[i]) {
                arr[1] = i + 1;
                break;
            }
        }
        if (arr[1] == 0) {

            for (int i = r + 1; i < nums.length; i++) {
                if (i != nums[i]) {
                    arr[1] = i;
                    break;
                }
            }
        }
        if (arr[1] == 0) {
            arr[1] = nums.length;
        }
        return arr;
    }
}
