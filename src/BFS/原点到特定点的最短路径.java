package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 周杰伦 on 2018/3/31.
 */
public class 原点到特定点的最短路径 {
    //查询最短路径时，节点需要保存此时的长度信息，否则没办法得知长度。
    public static void main(String[] args) {
        int [][]a = {{1,1,0,1},
                     {1,0,1,0},
                     {1,1,1,1},
                     {1,0,1,1}};
        System.out.println(minPathLength(a,3,3));
    }
//    public static int minPathLength(int[][] grids, int tr, int tc) {
//        if (grids == null)return 0;
//        int m = grids.length;
//        int n = grids[0].length;
//        if (tr > m || tr < 0 || tc > n || tc < 0)return 0;
//        int [][]go = {{0,1},{0,-1},{1,0},{-1,0}};
//        Queue<int []> queue = new LinkedList<>();
//        int []start = {0,0};
//        queue.offer(start);
//        int len = 0;
//        while (!queue.isEmpty()) {
//            int []a = queue.poll();
//            int r = a[0];
//            int c = a[1];
//
//            for (int i = 0;i < go.length;i ++) {
//                int []pos = new int[2];
//                pos[0] = r + go[i][0];
//                pos[1] = c + go[i][1];
//                if (pos[0] >= 0 && pos[0] < m && pos[1] >= 0 && pos[1] < n) {
//                    if (grids[pos[0]][pos[1]] == 1) {
//                        grids[pos[0]][pos[1]] = 0;
//                        if (pos[0] == tr && pos[1] == tc)return len;
//                        queue.offer(pos);
//                    }
//
//                }
//            }
//        }
//        return len;
//    }




    public static int minPathLength(int[][] grids, int tr, int tc) {
        int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grids.length, n = grids[0].length;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1));
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                Position nextPos = new Position(pos.r + next[i][0], pos.c + next[i][1], pos.length + 1);
                if (nextPos.r < 0 || nextPos.r >= m || nextPos.c < 0 || nextPos.c >= n) continue;
                if (grids[nextPos.r][nextPos.c] != 1) continue;
                grids[nextPos.r][nextPos.c] = 0;
                if (nextPos.r == tr && nextPos.c == tc) return nextPos.length;
                queue.add(nextPos);
            }
        }
        return -1;
    }

    private static class Position {
        int r, c, length;
        public Position(int r, int c, int length) {
            this.r = r;
            this.c = c;
            this.length = length;
        }
    }
}
