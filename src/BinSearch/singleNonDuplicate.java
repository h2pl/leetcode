package BinSearch;

/**
 * Created by 周杰伦 on 2018/3/16.
 */
public class singleNonDuplicate {
    public static void main(String[] args) {
        int []num = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(num));
    }
    public int singleNonDuplicate1(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
    public static int singleNonDuplicate(int[] nums) {
        int l = 0,r = nums.length - 1;
        if (nums.length <= 2) {
            return nums[0];
        }
        if (nums[1] != nums[0]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m + 1] != nums[m] && nums[m] != nums[m - 1]) {
                return nums[m];
            }
            if (m - 1 >= 0 && nums[m] == nums[m - 1]) {
                r = m - 1;
            }else if (m + 1 < nums.length && nums[m] == nums[m + 1]) {
                l = m + 1;
            }else {
                return nums[m];
            }
        }
        return nums[l];
    }
}
