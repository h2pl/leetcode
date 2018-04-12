package 数学.其他;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 乘积数组 {
    public static void main(String[] args) {
        int []a = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }

    // 不用除法
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] ret = new int[n];
//        ret[0] = 1;
//        int left = 1;
//        for (int i = 1; i < n; i++) {
//            ret[i] = left * nums[i - 1];
//            left *= nums[i - 1];
//        }
//        int right = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            ret[i] *= right;
//            right *= nums[i];
//        }
//        return ret;
//    }

    //用了除法
    public static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1)return nums;
        int all = 1;
        int cnt = 0;
        int index = 0;
        for (int i = 0; i < nums.length;i ++) {
            if (nums[i] != 0) {
                all *= nums[i];
            }else {
                cnt ++;
                if (cnt == 2) {
                    break;
                }
                index = i;
            }
        }
        if (cnt == 2) {
            Arrays.fill(nums, 0);
            return nums;
        }else {
            if (index != 0) {
                Arrays.fill(nums, 0);
                nums[index] = all;
                return nums;
            }else {
                for (int i = 0;i < nums.length;i ++) {
                    nums[i] = all / nums[i];
                }
                return nums;
            }
        }
    }
}
