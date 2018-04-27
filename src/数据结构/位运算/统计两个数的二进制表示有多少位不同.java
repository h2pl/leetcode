package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 统计两个数的二进制表示有多少位不同 {
    //正确做法，使用异或
    public int hammingDistance(int x, int y){
        int z = x ^ y;
        //异或的结果中，1所在的位就是x和y不同的位
        int cnt = 0;
        while (z != 0) {
            //最高位是否为1
            if ((z & 1) == 1) {
                cnt ++;
                //依次判断低位是否为1
            }
            z = z >> 1;
        }
        return cnt;
    }
   // 正确方法2
//    使用 z&(z-1) 去除 z 位级表示最低的那一位。
//
//    public int hammingDistance(int x, int y) {
//        int z = x ^ y;
//        int cnt = 0;
//        while (z != 0) {
//            z &= (z - 1);
//            cnt++;
//        }
//        return cnt;
//    }
//
// 方法3 这个方法补错
//    可以使用 Integer.bitcount() 来统计 1 个的个数。
//
//    public int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);


        //错误做法，使用字符串比较
//    public static int hammingDistance(int x, int y) {
//        String s1 = Integer.toBinaryString(x);
//        String s2 = Integer.toBinaryString(y);
//        String temp;
//        if (s1.length() >= s2.length()) {
//            temp = s1;
//            s1 = s2;
//            s2 = temp;
//        }
//        System.out.println(s1);
//        System.out.println(s2);
//        int i = s1.length() - 1;
//        int j = s2.length() - 1;
//        int cnt = 0;
//        while (i >= 0 && j >= 0) {
//            if (s1.charAt(i) != s2.charAt(j)) {
//                cnt ++;
//                i --;
//                j --;
//                continue;
//            }
//            i --;
//            j --;
//        }
//        while (j >= 0) {
//            if (s2.charAt(j) == '1') {
//                cnt ++;
//                j --;
//                continue;
//            }
//            j --;
//
//        }
//        return cnt;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(hammingDistance(3,1));
//    }
}
