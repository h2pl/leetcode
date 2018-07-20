package DFS;

/**
 * Created by 周杰伦 on 2018/7/19.
 */
public class 朋友圈 {
    public static void main(String[] args) {
        int [][]a = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(findCircleNum(a));
    }
    private static int n;

    public static int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i ++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private static void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }
//    private static int n;
//    public static int findCircleNum(int[][] M) {
//        n = M.length;
//        int cnt = 0 ;
//        int []visit = new int[n];
//        for (int i = 0;i < M.length;i ++) {
//            if(visit[i] == 0)  {
//                dfs(M, visit, i);
//                cnt ++;
//            }
//        }
//        return cnt;
//    }
//    public static void dfs(int[][]M, int[] visit, int i) {
//        visit[i] = 1;
//        for (int j = 0;j < M.length;j ++) {
//            if(visit[j] == 0 && M[i][j] == 1)  {
//                dfs(M, visit, i);
//            }
//        }
//    }
}
