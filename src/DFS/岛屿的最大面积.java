package DFS;

/**
 * Created by 周杰伦 on 2018/7/18.
 */
public class 岛屿的最大面积 {
    public static void main(String[] args) {
        int [][]a = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(a));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int [][]visit = new int[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0;i < grid.length;i ++) {
            for (int j = 0;j < grid[0].length;j ++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, visit, 0));
                }
            }
        }
        return max;
    }

    public static int dfs(int [][]grid, int x, int y, int [][]visit, int count) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return count;
        }
        if (visit[x][y] == 1 || grid[x][y] == 0) {
            return count;
        }

        visit[x][y] = 1;
        count ++;

        count += dfs(grid, x + 1, y, visit, 0);
        count += dfs(grid, x - 1, y, visit, 0);
        count += dfs(grid, x, y + 1, visit, 0);
        count += dfs(grid, x, y - 1, visit, 0);
        return count;
    }
}
