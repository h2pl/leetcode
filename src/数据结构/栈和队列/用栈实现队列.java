package 数据结构.栈和队列;

import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 用栈实现队列 {
    //一个栈实现，内部用一个栈进行倒序
    class MyQueue1 {
        private Stack<Integer> st = new Stack();

        public void push(int x) {
            Stack<Integer> temp = new Stack();
            while (!st.isEmpty()) {
                temp.push(st.pop());
            }
            st.push(x);
            while (!temp.isEmpty()) {
                st.push(temp.pop());
            }
        }

        public int pop() {
            return st.pop();
        }

        public int peek() {
            return st.peek();
        }

        public boolean empty() {
            return st.isEmpty();
        }
    }
    //两个栈实现
    class MyQueue {
        private Stack<Integer> in = new Stack();
        private Stack<Integer> out = new Stack();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        private void in2out() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
