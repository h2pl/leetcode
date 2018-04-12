package 贪心;

/**
 * Created by 周杰伦 on 2018/3/17.
 * 题目描述：判断一个数组能不能只修改一个数就成为非递减数组。

 在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，
 使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作 。优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] 的话，那么 nums[i] 这个数会变大，那么就有可能比 nums[i + 1] 大，从而影响了后续操作。还有一个比较特别的情况就是 nums[i] < nums[i - 2]，只修改 nums[i - 1] = nums[i] 不能令数组成为非递减，
 只能通过修改 nums[i] = nums[i - 1] 才行。
 */
public class 修改一个数成为非递减数组 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 0;i < nums.length - 1;i ++) {
            if(nums[i] <= nums[i+1]) {
                continue;
            }
            if(i - 1 >= 0 && nums[i+1] < nums[i -1]){
                nums[i+1] = nums[i];
            }else nums[i] = nums[i+1];
            count ++;
        }
        return count<=1;
    }
}
