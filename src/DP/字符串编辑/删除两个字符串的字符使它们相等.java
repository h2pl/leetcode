package DP.字符串编辑;

/**
 * Created by 周杰伦 on 2018/4/9.
 */
public class 删除两个字符串的字符使它们相等 {
    public static void main(String[] args) {
        String a = "eat";
        String b = "sea";
        System.out.println(minDistance(a, b));
        System.out.println(LCS(a, b));
    }
    public static int minDistance(String word1, String word2) {
        int len = LCS(word1, word2);
        return word1.length() + word2.length() - len - len;
    }
    public static int LCS(String a, String b) {
        if (a.equals("") || b.equals(""))return 0;
        //a的前i个字符与b的前j个字符的公共子序列长度
        int [][]dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0;i < dp.length;i ++) {
            dp[i][0] = 0;
        }
        for (int i = 0;i < dp[0].length;i ++) {
            dp[0][i] = 0;
        }
        for (int i = 1;i <= a.length();i ++) {
            for (int j = 1;j <= b.length();j ++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
