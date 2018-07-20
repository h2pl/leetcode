package BinSearch;

/**
 * Created by 周杰伦 on 2018/3/16.
 */
public class arrangeCoins {
    public int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        int rem = n,count = 0;
        for(int i = 1;i <= n;i++) {
            if(rem >= i) {
                rem = rem - i;
                count ++;
            }
            else return count;
        }
        return count;
    }
}
