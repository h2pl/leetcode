package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 周杰伦 on 2018/7/7.
 */
public class 出现频率最高的k个数 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        ArrayList<Integer>[] timesMap = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int times = map.get(key);
            if (timesMap[times] == null) {
                timesMap[times] = new ArrayList<>();
                timesMap[times].add(key);
            }
            else {
                timesMap[times].add(key);
            }
        }
        List<Integer> top = new ArrayList<Integer>();
        for (int i = timesMap.length - 1;i > 0 && top.size() < k;i ++) {
            if (timesMap[i] != null) {
                top.addAll(timesMap[i]);
            }
        }
        return top;
    }
}
