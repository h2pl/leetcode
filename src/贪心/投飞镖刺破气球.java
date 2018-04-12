package 贪心;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/3/16.
 * 题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直射向坐标轴，
 * 使得路径上的气球都会刺破。求解最小的投飞镖次数使所有气球都被刺破。

 从左往右投飞镖，并且在每次投飞镖时满足以下条件：

 左边已经没有气球了；
 本次投飞镖能够刺破最多的气球。
 */
public class 投飞镖刺破气球 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)return 0;
        Arrays.sort(points, (a,b) -> a[1] - b[1]);
        int curPos = points[0][1];
        int ret = 1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]<curPos) {
                continue;
            }
            curPos = points[i][1];
            ret++;
        }
        return ret;
    }
}
