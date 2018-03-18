package BinSearch;

/**
 * Created by 周杰伦 on 2018/3/16.
 */
public class singleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }
}
