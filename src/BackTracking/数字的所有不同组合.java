package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/2.
 */
public class 数字的所有不同组合 {
    public static void main(String[] args) {
        int n = 4,k = 2;
        System.out.println(Arrays.toString(combine(n,k).toArray()));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        backTracking(arr,1, n, k, list);
        return list;
    }
    public static void backTracking(List<Integer> arr,int left, int n, int k, List<List<Integer>> list) {
        if (arr.size() == k) {
            list.add(new ArrayList(arr));
            return;
        }
        for (int i = left;i <= n;i ++) {
            arr.add(i);
            backTracking(arr, i + 1, n, k, list);
            arr.remove(arr.size() - 1);
        }
        return;

    }
}
