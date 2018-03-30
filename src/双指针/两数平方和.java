package 双指针;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 两数平方和 {
    public boolean judgeSquareSum(int c) {
        double i = 0,j = Math.floor(Math.pow(c,0.5));
        while (i <= j) {
            if (i <= j && Math.pow(i,2) + Math.pow(j,2) == c) return true;
            else if (i <= j && Math.pow(i,2) + Math.pow(j,2) > c) {
                j --;
            }
            else if (i <= j && Math.pow(i,2) + Math.pow(j,2) < c) {
                i ++;
            }
        }
        return false;
    }
}
