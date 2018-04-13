package 数据结构.栈和队列;

import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 最小值栈 {
    //入栈时压入当前最小值。
    //出栈时出栈当前最小值。
    //注意所有入栈出栈操作数据栈和最小值栈要一致，否则当多个元素相同时会出错。
    class MinStack {

        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        private int min;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            dataStack.add(x);
            min = Math.min(min, x);
            minStack.add(min);
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? min = Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
