package 贪心;

/**
 * Created by 周杰伦 on 2018/3/17.
 * 题目描述：花朵之间至少需要一个单位的间隔。
 */
public class 种植花朵 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for(int i = 0;i < flowerbed.length; i++){
            if(flowerbed[i] ==1)continue;
            int pre = i == 0 ? 0 : flowerbed[i-1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];
            if(pre == 0 && next == 0) {
                flowerbed[i] = 1;
                cnt ++;
            }
        }
        return cnt>=n;
    }
}
