package 贪心;

import java.util.Arrays;

/**
 * 题目描述：每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于一个孩子的满足度，该孩子才会获得满足。
 * 求解最多可以获得满足的孩子数量。

 因为最小的孩子最容易得到满足，因此先满足最小孩子。给一个孩子的饼干应当尽量小又能满足该孩子，
 这样大饼干就能拿来给满足度比较大的孩子。

 贪心算法
 */
public class 分配饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int i = 0,j=0;i<g.length && j<s.length;) {
            if(g[i]<=s[j]){
                count ++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}
