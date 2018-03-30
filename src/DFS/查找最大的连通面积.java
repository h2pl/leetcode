package DFS;

import java.util.Arrays;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 查找最大的连通面积 {
    public static void main(String[] args) {
        int [][]a = {{0,1},{1,1}};
        System.out.println(maxAreaOfIsland(a));
    }
    static int max = 0;
    static int count = 0;
    public static int maxAreaOfIsland(int[][] grid) {
        max = 0;
        count = 0;
        if (grid == null)return 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][]visit = new int[m][n];
        for (int i = 0;i < visit.length;i ++) {
            Arrays.fill(visit[i],0);
        }

        for (int i = 0;i < m;i ++) {
            for (int j = 0;j < n;j ++) {
                count = 0;
                if (grid[i][j] == 1) {
                    dfs(grid, visit, i, j);
                }
                if (count > max) max = count;
            }
        }
        return max;
    }
    public static void dfs(int [][]grid,int [][]visit, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||grid[x][y] == 0 || visit[x][y] == 1) return;

        visit[x][y] = 1;
        count ++;
        dfs(grid,visit,x + 1,y);
        dfs(grid,visit,x,y + 1);
        dfs(grid,visit,x - 1,y);
        dfs(grid,visit,x ,y - 1);
        return;
    }
}
