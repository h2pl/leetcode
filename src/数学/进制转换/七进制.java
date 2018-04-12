package 数学.进制转换;

import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/11.
 */
public class 七进制 {
    //用栈进行进制转换
    public static void main(String[] args) {
        System.out.println(convertToBase7(-8));
        System.out.println(convertToBase7(-7));
    }
    public static String convertToBase7(int num) {
        if (num == 0)return "0";
        int flag = 1;
        Stack<Integer> stack = new Stack<>();
        if (num < 0) {
            flag = -1;
            num = - num;
        }
        while (num != 0) {
            int rem = num % 7;
            num = num / 7;
            stack.push(rem);
        }
        String res = "";

        while (!stack.isEmpty()) {
            int last = stack.pop();
            res = res + String.valueOf(last);
        }
        if (flag == - 1) {
            res = "-" + res;
        }
        return res;
    }

}
