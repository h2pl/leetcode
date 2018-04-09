package DP.数组区间;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 数组区间和 {
    class NumArray {
        private int[] sums;

        // 求区间 i ~ j 的和，可以转换为 sum[j] - sum[i-1]，其中 sum[i] 为 0 ~ i 的和。
        public NumArray(int[] nums) {
            sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                sums[i] = i == 0 ? nums[0] : sums[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sums[j] : sums[j] - sums[i - 1];
        }
    }
}
