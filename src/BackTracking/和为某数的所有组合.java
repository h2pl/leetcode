package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/2.
 */
public class 和为某数的所有组合 {
    public static void main(String[] args) {
        int []a = {2,3,6,7};
        System.out.println(Arrays.toString((combinationSum(a,7).toArray())));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        backTracking(arr, 0, 0, candidates, target, list);
        return list;
    }

    public static void backTracking(List<Integer> arr,int cur,int sum,int[]nums, int target, List<List<Integer>> list) {
        if (sum == target) {
            list.add(new ArrayList(arr));
            return;
        }
        for (int i = cur;i < nums.length;i ++) {
            //终止条件很重要，否则会死循环
            if (sum + nums[i] <= target) {
                arr.add(nums[i]);
                sum += nums[i];
                backTracking(arr, i, sum, nums, target, list);
                sum -= nums[i];
                arr.remove(arr.size() - 1);
            }
        }
        return;

    }
}
