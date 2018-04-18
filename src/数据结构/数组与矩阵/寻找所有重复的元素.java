package 数据结构.数组与矩阵;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 寻找所有重复的元素 {
    public static void main(String[] args) {
        int []a = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(a));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int []arr = new int[nums.length + 1];
        for (int i = 0;i < nums.length;i ++) {
            if (arr[nums[i]] == 0) {
                arr[nums[i]] = 1;
            }else {
                arr[nums[i]] = 2;
            }
        }
        for (int i = 1;i < arr.length;i ++) {
            if (arr[i] == 2) {
                list.add(i);
            }
        }
        return list;
    }
}
