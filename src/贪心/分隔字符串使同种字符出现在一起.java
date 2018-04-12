package 贪心;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/3/17.
 */
public class 分隔字符串使同种字符出现在一起 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        int[] lastIdxs = new int[26];
        for(int i = 0; i < S.length(); i++) lastIdxs[S.charAt(i) - 'a'] = i;
        int start = 0;
        while (start<S.length()) {
            int end = start;
            for (int i = start; i < S.length() && i <= end; i++) {
                int last = lastIdxs[S.charAt(i) - 'a'];
                if (last == i) continue;
                if (last > end) end = last;

            }
            ret.add(end - start +1);
        }
        return ret;
    }
}
