package 数据结构.栈和队列;

import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 括号匹配 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i ++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' : stack.push(c);
                break;
                case '[' : stack.push(c);
                break;
                case '{' : stack.push(c);
                break;
                case ')' : {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        break;
                    }else return false;
                }
                case ']' : {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                        break;
                    }else return false;
                }
                case '}' : {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }else return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }else return false;
    }
}
