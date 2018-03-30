package DFS;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 图的连通分量个数 {
    static int count = 0;
    public static int findCircleNum(int[][] M) {

        count = 0;
        if (M == null)return 0;
        int m = M.length;
        int n = M[0].length;
        int [][]visit = new int[m][n];
        for (int i = 0;i < visit.length;i ++) {
            Arrays.fill(visit[i],0);
        }

        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (M[i][j] == 1 && visit[i][j] != 1) {
                    dfs(M, visit, i, j);
                    count ++;
                }
            }
        }
        return count;
    }
    public static void dfs(int [][]grid,int [][]visit, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||grid[x][y] == 0 || visit[x][y] == 1) return;

        visit[x][y] = 1;
        dfs(grid,visit,x + 1,y);
        dfs(grid,visit,x,y + 1);
        dfs(grid,visit,x - 1,y);
        dfs(grid,visit,x ,y - 1);
        return;
    }
}
