package 双指针;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 回文字符串 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
    }
    public static boolean validPalindrome(String s) {
        int i = 0,j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return Palindrome(s,i + 1, j) || Palindrome(s, i, j - 1);
            }
            i ++;
            j --;
        }
        return true;
    }
    public static boolean Palindrome(String s, int l, int r) {
        int i = l,j = r;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}
