package 数学.其他;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 平方数 {

//    平方序列：1,4,9,16,.. 间隔：3,5,7,...
//
//    间隔为等差数列，使用这个特性可以得到从 1 开始的平方序列。
//
//    public boolean isPerfectSquare(int num) {
//        int subNum = 1;
//        while (num > 0) {
//            num -= subNum;
//            subNum += 2;
//        }
//        return num == 0;
//    }

    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0)return true;
        for (int i = 2;i <= num / 2;i ++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
