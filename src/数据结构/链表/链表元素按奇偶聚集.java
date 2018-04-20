package 数据结构.链表;

import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/20.
 */
public class 链表元素按奇偶聚集 {
    //是按照元素的次序中的奇偶数，而不是节点值的奇偶数
    public ListNode oddEvenList(ListNode head) {
        if (head == null)return head;
        if (head.next == null)return head;
        ListNode even = new ListNode(0);
        ListNode odd = new ListNode(0);
        ListNode l1 = even;
        ListNode l2 = odd;
        ListNode p = head;
        int cnt = 1;
        while (p != null) {
            if (cnt % 2 ==  0) {
                even.next = p;
                even = even.next;
            }else {
                odd.next = p;
                odd = odd.next;
            }
            cnt ++;
            p = p.next;
        }
        even.next = null;
        odd.next = l1.next;
        return l2.next;
    }
}
