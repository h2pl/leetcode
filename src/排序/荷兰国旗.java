package 排序;

/**
 * Created by 周杰伦 on 2018/7/7.
 */
public class 荷兰国旗 {
    public void sortColors(int[] nums) {
        if (nums.length <= 1)return;
        int zero = -1, one = 0,two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            }else if (nums[one] == 2) {
                swap(nums, --two, one);
            }else {
                one ++;
            }
        }
    }
    public void swap(int []nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
