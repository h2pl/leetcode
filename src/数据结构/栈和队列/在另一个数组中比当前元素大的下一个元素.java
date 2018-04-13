package 数据结构.栈和队列;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 在另一个数组中比当前元素大的下一个元素 {
    //这题的测试用例有点问题
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []big = new int[nums1.length];
        Arrays.fill(big, -1);
        for (int i = 0;i < nums1.length;i ++) {
            for (int j = i + 1;j < nums2.length;j ++) {
                if (nums2[j] > nums1[i]) {
                    big[i] = nums2[j];
                    break;
                }
            }
        }
        return big;
    }
}
