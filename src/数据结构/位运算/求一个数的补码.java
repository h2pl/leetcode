package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 求一个数的补码 {


//    ///题目描述：不考虑二进制表示中的首 0 部分。
//
//    对于 00000101，要求补码可以将它与 00000111 进行异或操作。那么问题就转换为求掩码 00000111。
//
//    public int findComplement(int num) {
//        if (num == 0) return 1;
//        int mask = 1 << 30;
//        while ((num & mask) == 0) mask >>= 1;
//        mask = (mask << 1) - 1;
//        return num ^ mask;
//    }
//    可以利用 Java 的 Integer.highestOneBit() 方法来获得含有首 1 的数。
//
//    public int findComplement(int num) {
//        if (num == 0) return 1;
//        int mask = Integer.highestOneBit(num);
//        mask = (mask << 1) - 1;
//        return num ^ mask;
//    }
//    对于 10000000 这样的数要扩展成 11111111，可以利用以下方法：
//
//    mask |= mask >> 1    11000000
//    mask |= mask >> 2    11110000
//    mask |= mask >> 4    11111111
//    public int findComplement(int num) {
//        int mask = num;
//        mask |= mask >> 1;
//        mask |= mask >> 2;
//        mask |= mask >> 4;
//        mask |= mask >> 8;
//        mask |= mask >> 16;
//        return (mask ^ num);
//    }

    public static void main(String[] args) {
        findComplement(-1);
    }
    public static int findComplement(int num) {
        if (num >= 0) return num;
        int mask = 1;
        mask = Integer.MIN_VALUE;
        mask -= 1;
        System.out.println(Integer.toBinaryString(num));
        num = num ^ mask;
        System.out.println(Integer.toBinaryString(mask));
        System.out.println(Integer.toBinaryString(num));
        return 1;
    }
}
