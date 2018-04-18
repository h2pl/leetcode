package 数据结构.数组与矩阵.矩阵;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 有序矩阵查找 {
    public static void main(String[] args) {
        int [][]a = {
                      {1,   4,  7, 11, 15},
                      {2,   5,  8, 12, 19},
                      {3,   6,  9, 16, 22},
                      {10, 13, 14, 17, 24},
                      {18, 21, 23, 26, 30}
                    };
        System.out.println(searchMatrix(a,5));
        System.out.println(searchMatrix(a,20));

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)return false;
        for (int i = matrix[0].length - 1,j = 0;i >= 0 && j < matrix.length;) {
            if (target < matrix[j][i]) {
                i --;
            }else if (target > matrix[j][i]) {
                j ++;
            }else {
                return true;
            }
        }
        return false;
    }
}
