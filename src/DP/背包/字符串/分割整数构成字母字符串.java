package DP.背包.字符串;

/**
 * Created by 周杰伦 on 2018/4/3.
 */
public class 分割整数构成字母字符串 {
    public static void main(String[] args) {
        String a = "301";
        System.out.println(numDecodings(a));
    }

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }


//    public static int numDecodings(String s) {
//        if (s == null || s.equals(""))return 0;
//        if (s.equals("0"))return 0;
//        if (s.length() >= 2) {
//            String s1 = s.substring(0,2);
//            int l = Integer.parseInt(s1.substring(0,1));
//            int r = Integer.parseInt(s1.substring(1,2));
//            if (l == 0)return 0;
//            int m = l*10 + r;
//            if (r == 0 && s.length() == 2 && l < 3) return 1;
//            if (r == 0 && m > 26)return 0;
//            if (m > 0 && m <= 26) {
//                return 2;
//            }
//            else return 1;
//        }
//        //s = 1234
//        //dp[1] = 1 dp[2] = 2 dp[3] = 3 dp[4] = 3
//        int []dp = new int[s.length() + 1];
//        if (s.charAt(0) == '0') {
//            return 0;
//        }
//        else {
//            dp[1] = 1;
//        }
//        for (int i = 2;i <=s.length();i ++) {
//            int a = Integer.parseInt(s.substring(i-2,i-1));
//            int b = Integer.parseInt(s.substring(i - 1,i));
//            if (a == 0 && b == 0)return 0;
//            if (b == 0 && i == s.length()) {
//                if (a * 10 + b > 26) {
//                    return 0;
//                }
//                dp[i] = dp[i - 1] - 1;
//                break;
//            }
//            if (a == 0 || b == 0) {
//                dp[i] = dp[i - 1];
//                continue;
//            }
//            int num = a * 10 + b ;
//            if (num > 0 && num <= 26) {
//                dp[i] = dp[i - 1] + 1;
//            }else {
//                dp[i] = dp[i - 1];
//            }
//        }
//        return dp[s.length()];
//    }

}
