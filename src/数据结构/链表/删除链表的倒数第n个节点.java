package 数据结构.链表;

/**
 * Created by 周杰伦 on 2018/4/19.
 */
public class 删除链表的倒数第n个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)return null;
        //若要删除倒数第n个刚好与长度相等时。要另外判断，否则会出错。
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len ++;
        }
        if (n == len) {
            head = head.next;
            return head;
        }
        //一般情况下，直接用快慢指针，快指针先走n步。满指针负责删除。
        //当满指针前面没元素时，说明只有一个元素，返回空即可。
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 0;
        while (fast.next != null && cnt < n) {
            fast = fast.next;
            cnt ++;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
            return head;
        }else {
            return null;
        }
    }
}
