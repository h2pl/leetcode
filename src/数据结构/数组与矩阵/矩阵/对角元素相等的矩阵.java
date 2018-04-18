package 数据结构.数组与矩阵.矩阵;

/**
 * Created by 周杰伦 on 2018/4/17.
 */
public class 对角元素相等的矩阵 {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));
    }
    //按照每个斜行来判断，一旦有不同的值直接返回false
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m > n ? n : m;
        for (int i = 1;i < len;i ++) {
             if (matrix[i - 1][i - 1] != matrix[i][i]) {
                 return false;
             }
        }
        for (int i = 1;i < m - 1;i ++) {
            for (int j = 0;j < n - 1;j ++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        for (int i = 1;i < n - 1;i ++) {
            for (int j = 0;j < m - 1;j ++) {
                if (matrix[j][i] != matrix[j + 1][i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
