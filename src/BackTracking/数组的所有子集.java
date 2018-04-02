package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/2.
 */
public class 数组的所有子集 {
    public static void main(String[] args) {
        int []a = {1,2,3};
        System.out.println(Arrays.toString(subsets(a).toArray()));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int m = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1 ;i <= nums.length;i ++) {
            backTracking(arr, nums,0, i, list);
        }
        list.add(new ArrayList<>());
        return list;
    }
    public static void backTracking(ArrayList<Integer> arr, int []nums, int left , int len, List<List<Integer>> list) {
        if (arr.size() == len) {
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int i = left;i < nums.length && i < nums.length;i ++) {
            arr.add(nums[i]);
            backTracking(arr, nums, i + 1,len,list);
            arr.remove(arr.size()-1);
        }

        return;
    }
}
