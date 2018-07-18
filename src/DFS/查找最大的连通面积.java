package DFS;

import java.util.Arrays;
import java.util.Stack;

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

    //非递归写法
//    class Pos{
//        int x;
//        int y;
//        int count;
//
//        public Pos(int x, int y, int count) {
//            this.x = x;
//            this.y = y;
//            this.count = count;
//        }
//    }
//    public int stack(int [][]grid,int [][]visit, int x, int y) {
//        Stack<Pos> stack = new Stack<>();
//        stack.push(new Pos(x, y, 0));
//        int [][]pos = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
//        while (!stack.isEmpty()) {
//            Pos init = stack.peek();
//            for (int i = 0; i < pos.length; i++) {
//                int x0 = x + pos[i][0];
//                int y0 = y + pos[i][1];
//                if (visit[x0][y0] == 0 && grid[x0][y0] == 1) {
//                    stack.push(new Pos(x0, y0, init.count + 1));
//                    break;
//                }
//            }
//            stack.pop();
//        }
//    }
}
