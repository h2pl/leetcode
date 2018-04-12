package 数学.进制转换;

/**
 * Created by 周杰伦 on 2018/4/11.
 */
public class 十转十六进制 {
    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
        System.out.println(toHexOK(26));
        System.out.println(toHexOK(-1));
    }
    //无符号右移高位补0 >>>
    //有符号右移高位补1 >>>
    public static String toHexOK(int num) {
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
    public static String toHex(int num) {
        return Integer.toHexString(num);
    }
}
