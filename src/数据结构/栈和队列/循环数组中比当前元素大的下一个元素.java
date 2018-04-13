package 数据结构.栈和队列;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 循环数组中比当前元素大的下一个元素 {
    //旋转数组很好的解决方式就是复制一份接在后面
    public int[] nextGreaterElements(int[] nums) {
        int []big = new int[nums.length];
        int []newnum = new int[nums.length * 2];
        Arrays.fill(big, -1);
        for (int i = 0;i < nums.length;i ++) {
            newnum[i] = nums[i];
        }
        for (int i = nums.length;i < newnum.length;i ++) {
            newnum[i] = nums[i - nums.length];
        }
        for (int i = 0;i < nums.length;i ++) {
            for (int j = i + 1;j < newnum.length;j ++) {
                if (newnum[j] > nums[i]) {
                    big[i] = newnum[j];
                    break;
                }
            }
        }
        return big;
    }
}
