package 数学.相遇问题;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/12.每次可以对一个数组元素加一或者减一，求最小的改变次数。

 这是个典型的相遇问题，移动距离最小的方式是所有元素都移动到中位数。理由如下：

 设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，它们总共移动的次数为 b - a，这个值等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。

 设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。
 */
public class 改变数组元素使所有的数组元素都相等 {
    public static void main(String[] args) {
        int []a = {1,2,3};
        System.out.println(minMoves2(a));
    }
    //
    public static int minMoves2(int[] nums) {
        if (nums.length == 0)return 0;
        long []cost = new long[nums.length];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    cost[i] += Math.abs(nums[j] - nums[i]);
                }
            }
            if (cost[i] < min) {
                min = cost[i];
            }
        }
        return (int) min;
    }
//先排序，时间复杂度：O(NlogN)
//    public int minMoves2(int[] nums) {
//        Arrays.sort(nums);
//        int ret = 0;
//        int l = 0, h = nums.length - 1;
//        while(l <= h) {
//            ret += nums[h] - nums[l];
//            l++;
//            h--;
//        }
//        return ret;
//    }

//    解法 2

//    使用快速选择找到中位数，时间复杂度 O(N)
//
//    public int minMoves2(int[] nums) {
//        int ret = 0;
//        int n = nums.length;
//        int median = quickSelect(nums, 0, n - 1, n / 2 + 1);
//        for(int num : nums) ret += Math.abs(num - median);
//        return ret;
//    }
//
//    private int quickSelect(int[] nums, int start, int end, int k) {
//        int l = start, r = end, privot = nums[(l + r) / 2];
//        while(l <= r) {
//            while(nums[l] < privot) l++;
//            while(nums[r] > privot) r--;
//            if(l >= r) break;
//            swap(nums, l, r);
//            l++; r--;
//        }
//        int left = l - start + 1;
//        if(left > k) return quickSelect(nums, start, l - 1, k);
//        if(left == k && l == r) return nums[l];
//        int right = r - start + 1;
//        return quickSelect(nums, r + 1, end, k - right);
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
//    }
}
