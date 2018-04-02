package DFS;

/**
 * Created by 周杰伦 on 2018/3/31.
 */
public class 填充封闭区域 {
    //先把最外圈的0找出来，这些区域必定还是0，置为*
    //这些0锁直接相邻的0必定还是保留0，dfs把这些0全部置为*
    //剩下的0就是可以被围起来的0了，最后把*变为0,0变为x。
    //逆向思维，太赞了
    public static void main(String[] args) {

    }
    //我真是艹他妈了。
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            boundaryDFS(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            boundaryDFS(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            boundaryDFS(board, i, j+1);
    }
//    public void solve(char[][] board) {
//        if (board == null || board.length == 0)return;
//        int m = board.length;
//        int n = board[0].length;
//        if (m <= 2 || n <= 2)return;
//
//        int [][] visit = new int[m][n];
//        for (int i = 1;i < m - 1;i ++) {
//            for (int j = 1;j < n - 1;j ++) {
//                if (board[i][j] == 'O' && legal(board, i, j)) {
//                    backTracking(board,visit,i,j);
//                }
//            }
//        }
//    }
//    public boolean backTracking(char[][] board, int [][]visit, int x, int y) {
//        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
//        if (!legal(board, x, y)) return false;
//        if (board[x][y] == 'X') return true;
//        if (visit[x][y] == 1)return true;
//        visit[x][y] = 1;
//        if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1)return false;
//        if (board[x - 1][y] == 'X' && board[x + 1][y] == 'X' && board[x][y - 1] == 'X' && board[x][y + 1] == 'X') {
//            board[x][y] = 'X';
//            return true;
//        }
//        boolean left = backTracking(board,visit,x - 1,y);
//        if (!left) return false;
//        boolean right = backTracking(board,visit,x + 1,y);
//        if (!right) return false;
//        boolean up = backTracking(board,visit,x,y + 1);
//        if (!up) return false;
//        boolean down = backTracking(board,visit,x,y - 1);
//        if (!down) return false;
//
//        board[x][y] = 'X';
//
//        return true;
//    }
//
//    public boolean legal (char [][]board, int x,int y) {
//        int count = 0;
//        for (int i = 0;i < y;i ++) {
//            if (board[x][i] == 'X') count ++;
//        }
//        if (count < 1)return false;
//        count = 0;
//        for (int i = y;i < board[0].length;i ++) {
//            if (board[x][i] == 'X') count ++;
//        }
//        if (count < 1)return false;
//        for (int i = 0;i < x;i ++) {
//            if (board[i][y] == 'X') count ++;
//        }
//        if (count < 1)return false;
//        for (int i = x;i < board.length;i ++) {
//            if (board[i][y] == 'X') count ++;
//        }
//        if (count < 1)return false;
//        return true;
//    }

}
