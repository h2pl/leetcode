package BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/1.
 */
public class 找出所有数字组合 {
    public static void main(String[] args) {
        int []a = {1,2,3};
        System.out.println(Arrays.toString(permute(a).toArray()));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int m = nums.length;
        int []visit = new int[m];
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(arr, nums, visit, list);
        return list;
    }
    public static void dfs(ArrayList<Integer> arr, int []nums, int[]visit, List<List<Integer>> list) {
        if (arr.size() == nums.length) {
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0;i < nums.length;i ++) {
            if (visit[i] == 1) continue;
            visit[i] = 1;
            arr.add(nums[i]);
            dfs(arr, nums, visit,list);
            arr.remove(arr.size()-1);
            visit[i] = 0;
        }

        return;
    }

}
