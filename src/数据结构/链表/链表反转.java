package 数据结构.链表;

import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/19.
 */
public class 链表反转 {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        while (q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
