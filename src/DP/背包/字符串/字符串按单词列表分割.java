package DP.背包.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/6.
 */
public class 字符串按单词列表分割 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }
    //该题与完全背包还是有差异的。解法比较巧妙,最好记着
    public static boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] represents if s.substring(0, i) is wordbreakable.
        boolean []dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1;i <= s.length();i ++) {
            for (int j = 0;j < i;j ++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //这是一个完全背包问题，和 0-1 背包不同的是，完全背包中物品可以使用多次。
    // 在这一题当中，词典中的单词可以被使用多次。

    //0-1 背包和完全背包在实现上的不同之处是，0-1 背包对物品的迭代是在最外层，
    // 而完全背包对物品的迭代是在最里层。
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) { // 每个单词可以使用多次
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
