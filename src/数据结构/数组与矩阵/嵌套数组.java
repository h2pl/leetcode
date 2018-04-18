package 数据结构.数组与矩阵;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 嵌套数组 {
    public static void main(String[] args) {
        int []a = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(a));
    }
    // 访问矩阵的设置用意在于 每次从头开始访问能经历的所有元素都已经标记。
    // 后面如果有按照该路径访问的序列，长度都不会比此次序列长。
    public static int arrayNesting(int[] nums) {
        int cnt = 0;
        int max = 0;
        for (int j = 0;j < nums.length;j ++ ) {
            int index = j;
            cnt = 0;
            while (index < nums.length && nums[index] != -1) {
                cnt ++;
                int t = nums[index];
                nums[index] = -1;
                index = t;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }
}
