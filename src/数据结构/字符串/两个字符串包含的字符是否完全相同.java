package 数据结构.字符串;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 两个字符串包含的字符是否完全相同 {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (int i = 0;i < s.length();i ++) {
            map[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0;i < t.length();i ++) {
            map[s.charAt(i) - 'a'] -= 1;
        }
        for (int i : map) {
            if (i != 0)return false;
        }
        return true;
    }
}
