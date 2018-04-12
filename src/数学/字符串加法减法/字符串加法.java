package 数学.字符串加法减法;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 字符串加法 {
    public static void main(String[] args) {
        String a ="123";
        String b = "442";
        System.out.println(addStrings(a, b));
    }
    public static String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (carry == 1|| i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : num1.charAt(i --) - '0';
            int y = j < 0 ? 0 : num2.charAt(j --) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
