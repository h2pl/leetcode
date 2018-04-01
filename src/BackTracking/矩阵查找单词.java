package BackTracking;

/**
 * Created by 周杰伦 on 2018/4/1.
 */
public class 矩阵查找单词 {
    public static void main(String[] args) {
        char [][]a = {{'a','b'}};
        String b = "ba";
        System.out.println(b.charAt(0));
        System.out.println(b.charAt(0) == a[0][1]);
        System.out.println(exist(a,b));
    }
    public static boolean exist(char[][] board, String word) {
        boolean flag = false;
        int m = board.length;
        int n = board[0].length;
        int [][]visit = new int[m][n];
        for (int i = 0;i < m;i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, word, i, j, visit, 0)) {
                        return true;
                    }
                }
            }
        }
        return flag;

    }
    public static boolean find(char[][]board, String word, int i,int j,int[][]visit, int offset)
    {
        if (offset == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >=  board[0].length ||
                word.charAt(offset) != board[i][j] || visit[i][j] == 1) {
            return false;
        }

        visit[i][j] = 1;
        boolean flag = find(board, word, i + 1, j, visit, offset + 1)
        ||find(board, word, i, j + 1, visit, offset + 1)
        ||find(board, word, i - 1, j, visit, offset + 1)
        ||find(board, word, i, j - 1, visit, offset + 1);
        visit[i][j] = 0;
        return flag;

    }


}
