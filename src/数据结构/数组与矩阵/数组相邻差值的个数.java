package 数据结构.数组与矩阵;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/4/17.
 */
public class 数组相邻差值的个数 {
    //这题不会 注意一下
    //让前 k+1 个元素构建出 k 个不相同的差值，序列为：1 k+1 2 k 3 k-1 ... k/2 k/2+1.
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
//    public int[] constructArray(int n, int k) {
//        int []num = new int[n];
//        int []diff = new int[n];
//        Arrays.fill(diff, -1);
//        int x = 1;
//        for (int j = 1;j <= n;j ++) {
//            num[0] = j;
//            int cntk = 0;
//            for (int i = 2; i <= n; i++) {
//                if (diff[Math.abs(num[x] - num[x - 1])] == -1 && j != i && cntk < k) {
//                    num[x ++] = i;
//                    diff[Math.abs(num[x] - num[x - 1])] = 1;
//                }
//                if (k == cntk) {
//                    num[x ++] = i;
//                    if (x == n) {
//                        return num;
//                    }
//                }
//            }
//        }
//        return num;
//    }
}
