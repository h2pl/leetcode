package 双指针;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 归并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 1 && nums2.length == 0) return;
        if (nums1.length == 1 && nums2 != null)nums1[0] = nums2[0];
        int i = m - 1,j = n - 1;
        int index = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index --] = nums1[i];
                nums1[i] = 0;
                i --;
            }
            else {
                nums1[index --] = nums2[j];
                j --;
            }
        }
    }

}
