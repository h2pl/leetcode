package 数据结构.链表;

import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/19.
 */
public class 链表十进制求和 {
//    //写错了。链表的递归好烦啊
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode p = null;
//        ListNode q = null;
//        int len1 = size(l1);
//        int len2 = size(l2);
//        if (len1 == len2);
//        p = len1 > len2 ? l1:l2;
//        q = len1 < len2 ? l1:l2;
//        ListNode temp = p;
//        int l = len1 - len2;
//        while (l > 0) {
//            p = p.next;
//            l --;
//        }
//        int over = 0;
//        int val = p.val + add(p,q) + q.val;
//        if (val >= 10) {
//            p.val = val - 10;
//            over = 1;
//        }
//        int res = addsingle(temp, 1);
//        if (res == 1) {
//            ListNode h = new ListNode(1);
//            h.next = temp;
//            return h;
//        }else {
//            return temp;
//        }
//    }
//    public int addsingle(ListNode l,int cnt) {
//        if (l.next != null) {
//            l.val += addsingle(l.next, cnt);
//        }
//        if (l.val + cnt >= 10) {
//            l.val = l.val + cnt - 10;
//            return 1;
//        }else {
//            l.val = l.val + cnt;
//            return 0;
//        }
//    }
//    public int add(ListNode l1,ListNode l2) {
//        if (l1.next == null && l2.next == null) {
//            int over = l1.val + l2.val - 10;
//
//            if (over < 0) {
//                l1.val = l1.val + l2.val;
//                return 0;
//            }else {
//                l1.val = over;
//                return 1;
//            }
//        }
//        return add(l1.next,l2.next);
//    }
//    private int size(ListNode node) {
//        int size = 0;
//        while (node != null) {
//            size++;
//            node = node.next;
//        }
//        return size;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
