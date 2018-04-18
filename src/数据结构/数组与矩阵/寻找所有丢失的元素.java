package 数据结构.数组与矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 寻找所有丢失的元素 {
    public static void main(String[] args) {
        int []a = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(a));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int []arr = new int[nums.length + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i < nums.length;i ++) {
            arr[nums[i]] = 1;
        }
        for (int i = 1;i < arr.length;i ++) {
            if (arr[i] != 1) {
                list.add(i);
            }
        }
        return list;
    }
}
