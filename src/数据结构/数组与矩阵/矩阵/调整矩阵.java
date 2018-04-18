package 数据结构.数组与矩阵.矩阵;

/**
 * Created by 周杰伦 on 2018/4/17.
 */
public class 调整矩阵 {
    //先转存到一维数组，再重新放到新数组。
    //如果行列乘积不相等，直接返回原数组。
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length,n = nums[0].length;
        int [][] arr = new int[r][c];
        int []num = new int[m * n];
        if (m * n == r * c) {
            int k = 0;
            for (int i = 0 ;i < m;i ++) {
                for (int j = 0;j < n;j ++) {
                    num[k ++] = nums[i][j];
                }
            }
            k = 0;
            for (int i = 0;i < r;i ++) {
                for (int j = 0;j < c;j ++) {
                    arr[i][j] = num[k ++];
                }
            }
            return arr;
        }
        return nums;
    }
}
