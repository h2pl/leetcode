package 数学.其他;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 判断一个数是否是3的n次方 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(45));
    }
    // //1162261467是32位系统中，3的最高次幂19
    public static boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}
