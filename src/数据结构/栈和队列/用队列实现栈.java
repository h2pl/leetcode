package 数据结构.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 用队列实现栈 {
    //一个队列实现。每次插入时把除了队头之外的元素移到队尾。
    class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            int cnt = queue.size();
            while (cnt-- > 1) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    //两个队列实现
    //插入时直接插入。
    //pop时把除了队尾的元素移到队列2
    //队列2满时不能插入。
    class MyStack2 {

        private Queue<Integer> queue;
        private Queue<Integer> queue2;
        public MyStack2() {
            queue = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            while (queue.size() > 1) {
                queue2.add(queue.poll());
            }
            Integer res = queue.poll();
            while (!queue2.isEmpty()) {
                queue.add(queue2.poll());
            }
            return res;
        }

        public int top() {
            while (queue.size() > 1) {
                queue2.add(queue.poll());
            }
            Integer res = queue.peek();
            queue2.add(queue.poll());
            while (!queue2.isEmpty()) {
                queue.add(queue2.poll());
            }
            return res;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
