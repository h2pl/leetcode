package DFS;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 图的连通分量个数 {
    static int count = 0;
    public int findCircleNum(int[][] M) {
        count = 0;
        int []visit = new int[M.length];
        Arrays.fill(visit, 0);
        for (int i = 0;i < M.length;i ++) {
            if (visit[i] == 0) {
                dfs(M, i, visit);
                count ++;
            }
        }

        return count;
    }
    public void dfs (int [][]M, int j, int []visit) {
        for (int i = 0;i < M.length;i ++) {
            if (M[j][i] == 1 && visit[i] == 0) {
                visit[i] = 1;
                dfs(M, i, visit);
            }
        }
    }


}

