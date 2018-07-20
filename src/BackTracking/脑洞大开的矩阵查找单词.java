package BackTracking;

/**
 * Created by 周杰伦 on 2018/7/20.
 */
public class 脑洞大开的矩阵查找单词 {

    static class StopMsgException extends RuntimeException {

    }

    static boolean flag;

    public boolean exist(char[][] board, String word) {
        if (word.equals("")) {
            return true;
        }
        int[][] visit = new int[board.length][board[0].length];
        flag = false;
        try {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        dfs(board, word, visit, i, j);
                    }
                }
            }
        } catch (StopMsgException e) {
            System.out.println(e);
        }
        return flag;
    }

    public void dfs(char[][] board, String word, int[][] visit, int i, int j) {
        if (word.equals("")) {
            flag = true;
            throw new StopMsgException();
        }
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0) {
            return;
        }
        if (visit[i][j] == 1) {
            return;
        }

        if (word.charAt(0) == board[i][j]) {
            visit[i][j] = 1;
            dfs(board, word.length() == 1 ? "" : word.substring(1, word.length()), visit, i + 1, j);
            dfs(board, word.length() == 1 ? "" : word.substring(1, word.length()), visit, i - 1, j);
            dfs(board, word.length() == 1 ? "" : word.substring(1, word.length()), visit, i, j - 1);
            dfs(board, word.length() == 1 ? "" : word.substring(1, word.length()), visit, i, j + 1);
            visit[i][j] = 0;
        }
    }

}
