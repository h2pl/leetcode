package DFS;

/**
 * Created by 周杰伦 on 2018/3/31.
 */
public class 填充封闭区域 {
    public static void main(String[] args) {

    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0)return;
        int m = board.length;
        int n = board[0].length;
        if (m <= 2 || n <= 2)return;

        int [][] visit = new int[m][n];
        for (int i = 1;i < m - 1;i ++) {
            for (int j = 1;j < n - 1;j ++) {
                if (board[i][j] == 'O' && legal(board, i, j)) {
                    dfs(board,visit,i,j);
                }
            }
        }
    }
    public boolean dfs(char[][] board, int [][]visit, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if (!legal(board, x, y)) return false;
        if (board[x][y] == 'X') return true;
        if (visit[x][y] == 1)return true;
        visit[x][y] = 1;
        if (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1)return false;
        if (board[x - 1][y] == 'X' && board[x + 1][y] == 'X' && board[x][y - 1] == 'X' && board[x][y + 1] == 'X') {
            board[x][y] = 'X';
            return true;
        }
        boolean left = dfs(board,visit,x - 1,y);
        if (!left) return false;
        boolean right = dfs(board,visit,x + 1,y);
        if (!right) return false;
        boolean up = dfs(board,visit,x,y + 1);
        if (!up) return false;
        boolean down = dfs(board,visit,x,y - 1);
        if (!down) return false;

        board[x][y] = 'X';

        return true;
    }

    public boolean legal (char [][]board, int x,int y) {
        int count = 0;
        for (int i = 0;i < y;i ++) {
            if (board[x][i] == 'X') count ++;
        }
        if (count < 1)return false;
        count = 0;
        for (int i = y;i < board[0].length;i ++) {
            if (board[x][i] == 'X') count ++;
        }
        if (count < 1)return false;
        for (int i = 0;i < x;i ++) {
            if (board[i][y] == 'X') count ++;
        }
        if (count < 1)return false;
        for (int i = x;i < board.length;i ++) {
            if (board[i][y] == 'X') count ++;
        }
        if (count < 1)return false;
        return true;
    }

}
