package 双指针;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 最长子序列加强版 {
    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add("a");
        d.add("b");

        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) return o1.compareTo(o2);
                return o2.length() - o1.length();
            }
        });
        System.out.println(Arrays.toString(d.toArray()));
    }
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.equals(""))return "";
        if (d == null || d.size() == 0)return "";
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) return o1.compareTo(o2);
                return o2.length() - o1.length();
            }
        });
        for (String sub : d) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < sub.length()) {
                if (s.charAt(i) != sub.charAt(j)) {
                    i ++;
                }
                else {
                    i ++;
                    j ++;
                }
                if (j == sub.length()) {
                    return sub;
                }
            }
        }
        return "";
    }
}
