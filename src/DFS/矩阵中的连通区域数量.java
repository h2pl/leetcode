package DFS;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/3/31.
 */
public class 矩阵中的连通区域数量 {
    public static void main(String[] args) {

    }
    static int count = 0;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)return 0;
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][]visit = new int[m][n];
        for (int i = 0;i < visit.length;i ++) {
            Arrays.fill(visit[i],0);
        }
        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                if (grid[i][j] == '1' && visit[i][j] == 0) {
                    count ++;
                    dfs(grid,visit, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int [][]visit, int x,int y ) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||grid[x][y] == '0' || visit[x][y] == 1) return;
        visit[x][y] = 1;
        dfs(grid,visit,x + 1,y);
        dfs(grid,visit,x,y + 1);
        dfs(grid,visit,x - 1,y);
        dfs(grid,visit,x ,y - 1);
        return;
    }
}
