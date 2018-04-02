package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/2.
 */
public class 字符串划分成回文子串 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(partition("aab").toArray()));
    }
    public static List<List<String>> partition(String s) {
        List<String> arr = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        backTracking(s, 0, arr, list);
        return list;
    }
    public static void backTracking(String s,int left,List<String> arr, List<List<String>> list) {
        if (left == s.length()) {
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int i = left;i < s.length();i ++) {
            String substr = s.substring(left,i + 1);
            if (isHuiWen(substr)) {
                arr.add(substr);
                backTracking(s,i + 1,arr,list);
                arr.remove(arr.size() - 1);
            }
        }
    }
    public static boolean isHuiWen(String s) {
        if (s == null || s.equals(""))return false;
        if (s.length() == 1)return true;
        int l = 0,r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))return false;
            l ++;
            r --;
        }
        return true;
    }
}
