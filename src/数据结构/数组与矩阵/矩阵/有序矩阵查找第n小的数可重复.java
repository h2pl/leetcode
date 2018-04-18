package 数据结构.数组与矩阵.矩阵;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 有序矩阵查找第n小的数可重复 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int []arr = new int[m * n];
        int w = 0;
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                arr[w ++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
