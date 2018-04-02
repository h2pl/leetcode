package BackTracking;

import java.util.*;

/**
 * Created by 周杰伦 on 2018/4/2.
 */
public class 和为某数的所有组合2 {
    public static void main(String[] args) {
        int []a = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(Arrays.toString((combinationSum2(a,8).toArray())));

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(arr, 0, 0, candidates, target, list);
        return list;
    }

    public static void backTracking(List<Integer> arr,int cur,int sum,int[]nums, int target, List<List<Integer>> list) {
        if (sum == target) {
            if (!list.contains(arr))
            list.add(new ArrayList(arr));
            return;
        }
        for (int i = cur;i < nums.length;i ++) {
            //终止条件很重要，否则会死循环
            if (sum + nums[i] <= target) {
                arr.add(nums[i]);
                sum += nums[i];
                backTracking(arr, i + 1, sum, nums, target, list);
                sum -= nums[i];
                arr.remove(arr.size() - 1);
            }
        }
        return;

    }
}
