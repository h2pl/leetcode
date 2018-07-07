package 排序;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/7/7.
 */
public class 根据字符出现频率排序 {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    public static String frequencySort(String s) {
        int []arr = new int[128];
        char []crr = s.toCharArray();
        for (char c : crr) {
            arr[c]++;
        }

        List<Character>[]times = new ArrayList[s.length() + 1];
        for (int i = 0;i < arr.length;i ++) {
            if (times[arr[i]] == null) {
                times[arr[i]] = new ArrayList<>();
                times[arr[i]].add((char) (i));
            }else {
                times[arr[i]].add((char) (i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = times.length - 1;i > 0 ;i --) {
            if (times[i] != null) {
                for (char c : times[i]) {
                    int time = 0;
                    while (time < i) {
                        sb.append(c);
                        time ++;
                    }
                }
            }
        }
        return sb.toString();
    }
}
