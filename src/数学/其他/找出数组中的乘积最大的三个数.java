package 数学.其他;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 找出数组中的乘积最大的三个数 {
    public static void main(String[] args) {
        int []a = {1,2,3,4};
        System.out.println(maximumProduct(a));
    }
    public static int maximumProduct(int[] nums) {
        if(nums.length < 3) return 0;
        if(nums.length == 3) return nums[0] * nums[1] * nums[2];
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        if ( nums[0] < 0 && nums[1] < 0) {
            max = nums[0] * nums[1] * nums[nums.length - 1];
        }
        if (nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3] > max) {
            max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }
        return max;
    }

//    public int maximumProduct(int[] nums) {
//        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//        for (int n : nums) {
//            if (n > max1) {
//                max3 = max2;
//                max2 = max1;
//                max1 = n;
//            } else if (n > max2) {
//                max3 = max2;
//                max2 = n;
//            } else if (n > max3) {
//                max3 = n;
//            }
//
//            if (n < min1) {
//                min2 = min1;
//                min1 = n;
//            } else if (n < min2) {
//                min2 = n;
//            }
//        }
//        return Math.max(max1*max2*max3, max1*min1*min2);
//    }
}
